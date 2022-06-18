package com.ishmamruhan.RestTemplateAndOutputFormatPractice.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate configRestTemplate(){
        RestTemplate template = new RestTemplate();

        /*
        *   We have two type of converters. cause Sometimes we got string as response, sometimes Json
        */
        template.getMessageConverters().add(new StringHttpMessageConverter());
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        return template;
    }
}
