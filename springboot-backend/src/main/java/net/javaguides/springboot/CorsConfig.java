package net.javaguides.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
  
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
        .allowedOrigins("http://thirunavukkarasuthangaraj.fun").allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}



