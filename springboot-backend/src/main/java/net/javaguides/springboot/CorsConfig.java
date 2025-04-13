package net.javaguides.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
  
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow all origins
        registry.addMapping("/**")
                .allowedOrigins("*") // Allows all origins
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
