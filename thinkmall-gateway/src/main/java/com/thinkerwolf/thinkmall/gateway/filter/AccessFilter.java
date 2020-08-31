package com.thinkerwolf.thinkmall.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 *
 */
public class AccessFilter extends ZuulFilter {
    
    @Override
    public String filterType() {
        // pre routing post error
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        String sessionId = ctx.getRequest().getParameter("sessionId");
        if (sessionId == null) {
            ctx.setResponseStatusCode(401);
            ctx.setSendZuulResponse(false);
            return null;
        }

        return null;
    }
}
