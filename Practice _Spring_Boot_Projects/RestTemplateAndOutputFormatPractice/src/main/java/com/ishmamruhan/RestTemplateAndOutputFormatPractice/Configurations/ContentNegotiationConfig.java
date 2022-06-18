package com.ishmamruhan.RestTemplateAndOutputFormatPractice.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ContentNegotiationConfig implements WebMvcConfigurer {

    /*
    *   First of all, we have to add a dependency at "Pom.xml" named= "jackson-dataformat-xml"
    *
    *   For Spring Boot Version (2.x) or (5) "WebMvcConfigurerAdapter" class has been depricated
    *   Instead, It has come with an interface called "WebMvcConfigurer"
    *
    *   Now, we can get response at our desired format using a param at the end
    *
    *   http://localhost:8080/data?mediaType=xml
    */

    @Override
    public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)                          // Setup param
                .parameterName("mediaType")                      // Which param we want to add
                .ignoreAcceptHeader(true)                        // We are not going to use header
                .useRegisteredExtensionsOnly(false)              // We not only use registered extension but also our custom extension
                .defaultContentType(MediaType.APPLICATION_JSON)  // Default response will Json
                .mediaType("xml", MediaType.APPLICATION_XML)  // Media type XML is available
                .mediaType("json", MediaType.APPLICATION_JSON);  // Media type JSON is available

    }
}
