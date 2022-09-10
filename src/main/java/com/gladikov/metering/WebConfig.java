package com.gladikov.metering;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	registry.addViewController("/").setViewName("index");
	registry.addViewController("/login").setViewName("login");
	registry.addViewController("/admin").setViewName("admin");
	registry.addViewController("/403").setViewName("403");
	}
}
