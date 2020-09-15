package com.thinkerwolf.thinkmall.zuul.config;

import com.thinkerwolf.thinkmall.zuul.filter.AccessFilter;
import com.thinkerwolf.thinkmall.zuul.filter.LogReqRespFilter;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfiguration {

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    @Bean
    public LogReqRespFilter logReqRespFilter() {
        return new LogReqRespFilter();
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

    @Bean
    public ServiceConsumeFallbackProvider serviceConsumeFallbackProvider() {
        return new ServiceConsumeFallbackProvider();
    }

}
