package com.thinkerwolf.thinkmall.gateway.config;

import com.thinkerwolf.thinkmall.gateway.filter.AccessFilter;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    /**
     * 为符合要求的服务名称自动创建路径映射
     *
     * @return
     */
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
    }

}
