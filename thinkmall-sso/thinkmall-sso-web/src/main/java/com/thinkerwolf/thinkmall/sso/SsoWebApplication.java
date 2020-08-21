package com.thinkerwolf.thinkmall.sso;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SsoWebApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SsoWebApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }

}
