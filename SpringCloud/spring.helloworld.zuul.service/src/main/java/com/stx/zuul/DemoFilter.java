package com.stx.zuul;

/**  

* <p>Title: DemoFilter</p>  

* <p>Description: </p>  

* @author stx  

* @date 2019年3月20日  

*/
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
/*
 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下： 

pre：路由之前
routing：路由之时
post： 路由之后
error：发送错误调用
filterOrder：过滤的顺序   filterOrder：过滤的优先级，数字越大，优先级越低

pre：路由之前
routing：路由之时
post： 路由之后
error：发送错误调用
shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。 

run：过滤器的具体逻辑，这里只是将请求的URL简单些到日志中
 */
@Component
public class DemoFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(DemoFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    
    public boolean shouldFilter() {
        return true;
    }

    
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String s = String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString());
        log.info(s);
        return null;
    }
}
