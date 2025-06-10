package com.belajar.sales.utils;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientUtil implements InitializingBean, DisposableBean {

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl("https://ipubers.pupuk-indonesia.com").build();
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
