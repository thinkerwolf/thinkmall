package com.thinkerwolf.thinkmall.sso;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class WebSsoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(WebSsoApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }

}
