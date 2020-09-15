package com.thinkerwolf.thinkmall.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.util.IOUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class LogReqRespFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
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
        final RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        System.err.println("REQUEST:: " + req.getScheme() + " " + req.getRemoteAddr() + ":" + req.getRemotePort());
        StringBuilder params = new StringBuilder("?");
        // 获取URL参数
        Enumeration<String> names = req.getParameterNames();
        if (req.getMethod().equals("GET")) {
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                params.append(name);
                params.append("=");
                params.append(req.getParameter(name));
                params.append("&");
            }
        }
        if (params.length() > 0) {
            params.delete(params.length() - 1, params.length());
        }
        System.err.println(
                "REQUEST:: > " + req.getMethod() + " " + req.getRequestURI() + params + " " + req.getProtocol());
        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String name = (String) headers.nextElement();
            String value = req.getHeader(name);
            System.err.println("REQUEST:: > " + name + ":" + value);
        }

        // 获取请求体参数
        if (!ctx.isChunkedRequestBody()) {
            ServletInputStream inp = null;
            try {
                inp = req.getInputStream();
                String body = null;
                if (inp != null) {
                    body = IOUtils.toString(inp);
                    System.err.println("REQUEST:: > " + body);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
