package com.thinkerwolf.thinkmall.sso;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication
//@EnableDiscoveryClient
@SpringCloudApplication
@EnableFeignClients
@EnableHystrix
public class SsoWebApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SsoWebApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}
