package com.springboot.springbootexam.configuration.servlet.handler;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class BaseHandlerInterceptor implements HandlerInterceptor {
    Logger logger = (Logger) LoggerFactory.getLogger(getClass());
    
    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("prehandle requestURI : " + request.getRequestURI() );
        return true;
    }
    
    @Override
    public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle requestURI : " + request.getRequestURI());
    }
}
