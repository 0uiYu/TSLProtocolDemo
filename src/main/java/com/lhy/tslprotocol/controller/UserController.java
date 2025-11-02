package com.lhy.tslprotocol.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author lihaoyu
 * @date 2025/11/2 19:20
 * @description:
 */

// 文件：TlsClient.java
@RequestMapping("/user")
@RestController
@Slf4j
@AllArgsConstructor
public class UserController{

        private HttpClient client;


        @GetMapping("/send")
        public String sendRequest() throws Exception {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://httpbin.org/get"))
                        .timeout(java.time.Duration.ofSeconds(10))
                        .GET()
                        .build();

                // 3. 发送并获取响应
                HttpResponse<String> response = client.send(request,
                        HttpResponse.BodyHandlers.ofString());

                // 4. 打印结果
                System.out.println("状态码: " + response.statusCode());
                System.out.println("响应体: " + response.body());
                return "success";
        }

}

