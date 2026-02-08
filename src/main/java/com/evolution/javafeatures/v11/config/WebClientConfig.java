package com.evolution.javafeatures.v11.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${custom.web.client.baseurl}")
    String customWebClientBaseUrl;

    @Bean
    WebClient customWebClient(){
        return WebClient.builder()
                .baseUrl(customWebClientBaseUrl).build();
    }

}
