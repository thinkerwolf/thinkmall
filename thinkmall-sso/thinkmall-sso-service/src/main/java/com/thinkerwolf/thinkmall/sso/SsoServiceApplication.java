package com.thinkerwolf.thinkmall.sso;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SsoServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SsoServiceApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }
}
