package com.demo_deploye.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// @EnableWebMvc
public class ApplicationConfig implements WebMvcConfigurer {

    // @Override
    // public void addCorsMappings(CorsRegistry registry) {
    //     registry.addMapping("/**")
    //             .allowedOrigins("http://localhost:8000")
    //             .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTION")
    //             .allowedHeaders("Content-Type")
    //             .allowCredentials(true)
    //             .maxAge(3600);
    // }
}
