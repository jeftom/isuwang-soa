package com.isuwang.dapeng.impl.container;

import com.isuwang.dapeng.api.AppListener;
import com.isuwang.dapeng.api.Container;
import com.isuwang.dapeng.api.Plugin;
import com.isuwang.dapeng.api.SharedChain;
import com.isuwang.dapeng.api.events.AppEvent;
import com.isuwang.dapeng.api.events.AppEventType;
import com.isuwang.dapeng.core.Application;
import com.isuwang.dapeng.core.ProcessorKey;
import com.isuwang.dapeng.core.definition.SoaServiceDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class DapengContainer implements Container {

    private static final Logger logger = LoggerFactory.getLogger(DapengContainer.class);
    private List<AppListener> appListeners = new Vector<>();
    private List<Application> applications = new Vector<>();
    private List<Plugin> plugins = new ArrayList<>();
    private SharedChain sharedChain;
    private Map<ProcessorKey, SoaServiceDefinition<?>> processors = new ConcurrentHashMap<>();
    private Map<ProcessorKey,Application>  applicationMap = new ConcurrentHashMap<>();

    @Override
    public void registerAppListener(AppListener listener) {
        this.appListeners.add(listener);
    }

    @Override
    public void unregisterAppListener(AppListener listener) {
        this.appListeners.remove(listener);
    }

    @Override
    public void registerApplication(Application app) {
        this.applications.add(app);
        this.appListeners.forEach(i -> {
            try {
                i.appRegistered(new AppEvent(app, AppEventType.REGISTER));
            } catch (Exception e) {
                logger.error(" Faild to handler appEvent. listener: {}, eventType: {}",i, AppEventType.REGISTER , e.getStackTrace());
            }
        });
    }

    @Override
    public void unregisterApplication(Application app) {
        this.applications.remove(app);
        this.appListeners.forEach(i -> {
            try {
                i.appUnRegistered(new AppEvent(app, AppEventType.UNREGISTER));
            } catch (Exception e) {
                logger.error(" Faild to handler appEvent. listener: {}, eventType: {}",i, AppEventType.UNREGISTER , e.getStackTrace());
            }
        });
    }

    @Override
    public void registerPlugin(Plugin plugin) {
        this.plugins.add(plugin);
    }

    @Override
    public void unregisterPlugin(Plugin plugin) {
        this.plugins.remove(plugin);
    }

    @Override
    public List<Application> getApplications() {
        return this.applications;
    }

    public void setSharedChain(SharedChain sharedChain) {
        this.sharedChain = sharedChain;
    }

    @Override
    public SharedChain getSharedChain() {
        //TODO: should return the bean copy..not the real one.

        return sharedChain;
    }

    @Override
    public List<Plugin> getPlugins() {
        //TODO: should return the bean copy..not the real one.
        return this.plugins;
    }

    @Override
    public Map<ProcessorKey, SoaServiceDefinition<?>> getServiceProcessors() {
        return this.processors;
    }

    @Override
    public void registerAppProcessors(Map<ProcessorKey, SoaServiceDefinition<?>> processors) {
        this.processors.putAll(processors);
    }

    @Override
    public Application getApplication(ProcessorKey key) {
        return applicationMap.get(key);
    }

    @Override
    public void registerAppMap(Map<ProcessorKey, Application> applicationMap) {
        this.applicationMap.putAll(applicationMap);
    }


}
