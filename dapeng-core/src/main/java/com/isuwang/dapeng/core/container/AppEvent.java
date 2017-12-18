package com.isuwang.dapeng.core.container;

import java.util.EventObject;

public class AppEvent extends EventObject {

    private AppEventType eventType;

    public AppEvent(Application application, AppEventType eventType) {
        super(application);
        this.eventType = eventType;
    }

    public AppEventType getEventType() {
        return this.eventType;
    }
}