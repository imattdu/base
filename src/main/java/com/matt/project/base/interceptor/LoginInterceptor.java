package com.matt.project.base.interceptor;

import com.matt.project.base.constant.LTagConst;
import com.matt.project.base.util.LogUtil;
import com.matt.project.base.bo.TraceMessage;
import com.matt.project.base.util.TraceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("test", "test");
        TraceMessage traceMessage = TraceUtil.getTraceMessage(request);
        request.setAttribute("TRACE_MESSAGE", traceMessage);
        log.info(LogUtil.genMsg(request, "_com_http_in", "test"));
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        TraceMessage traceMessage = TraceUtil.getTraceMessage(request);
        log.info(LogUtil.genMsg(request, LTagConst.COM_HTTP_OUT, request.getRequestURI()));
        // 释放
        traceMessage = null;
    }

}
