package com.ecommerce.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class LoggingConfig {

    private static final Logger logger = LoggerFactory.getLogger(LoggingConfig.class);

    // Add method-level logging
    @ControllerAdvice
    public static class MethodLoggingAdvice extends ResponseEntityExceptionHandler {

        @ExceptionHandler(Exception.class)
        public void logException(HttpServletRequest request, Exception ex, HandlerMethod handlerMethod) {
            logger.error("Exception in method: " + handlerMethod.getBeanType().getName() + "." +
                    handlerMethod.getMethod().getName() + "() with cause = " +
                    (ex.getCause() != null ? ex.getCause().toString() : "NULL") +
                    " and exception = " + ex.getMessage(), ex);
        }
    }
}