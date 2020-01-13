package com.bjfu.inspect.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceFileMappingConfig implements WebMvcConfigurer {
    @Value("${location.img}")
    private String folder;
    @Value("${location.imgPath}")
    private String imgPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(imgPath + "**").addResourceLocations("file:" + folder);
    }
}
