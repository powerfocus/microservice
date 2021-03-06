package org.py.microservice.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.java.Log;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cqpythagoras
 * @date 2021-03-06
 */
@Log
public class SimpleFilter extends ZuulFilter {

    @Override
    public String filterType() {
        log.info("zuul filter type");
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        log.info("should filter");
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(),
                request.getRequestURL().toString()));
        return null;
    }
}
