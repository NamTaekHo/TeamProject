package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//상품등록시 이미지 첨부를 위한 클래스

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/image/**")
				.addResourceLocations("file:/C:\\Users\\user\\Desktop\\whworkspace\\uploadfiles/");
	}
}
