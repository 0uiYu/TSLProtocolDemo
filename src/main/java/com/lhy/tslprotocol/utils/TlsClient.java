package com.lhy.tslprotocol.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

/**
 * @author lihaoyu
 * @date 2025/11/3 2:13
 * @description:
 */

@Configuration
public class TlsClient {

    @Bean
    public HttpClient getClient(){
        HttpClient client = HttpClient.newHttpClient();
        return client;
    }

}
