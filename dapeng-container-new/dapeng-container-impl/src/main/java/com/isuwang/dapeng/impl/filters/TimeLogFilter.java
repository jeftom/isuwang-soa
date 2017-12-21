package com.isuwang.dapeng.impl.filters;


import com.isuwang.dapeng.api.FilterChain;
import com.isuwang.dapeng.api.FilterContext;
import com.isuwang.dapeng.api.Filter;

/**
 * Created by lihuimin on 2017/12/11.
 */
public class TimeLogFilter implements Filter {

    TimeLogAttach attach;

    static class TimeLogAttach {
        long start;
    }

    @Override
    public void onEntry(FilterContext ctx, FilterChain next) {
        TimeLogAttach attach = new TimeLogAttach();
        attach.start = System.currentTimeMillis();
        //ctx.setAttach(this, attach);
       // next.onEntry();
    }

    @Override
    public void onExit(FilterContext ctx, FilterChain prev) {
       // TimeLogAttach attach = (TimeLogAttach) ctx.getAttach(this);
        long end  = System.currentTimeMillis();
        System.out.println("time: " + (end-attach.start) + "ms");

       // prev.onExit();
    }
}
