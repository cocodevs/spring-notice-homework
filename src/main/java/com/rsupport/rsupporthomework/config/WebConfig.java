package com.rsupport.rsupporthomework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

@Configuration
public class WebConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addFilter("httpMethodFilter", HiddenHttpMethodFilter.class)
                .addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");
    }
}