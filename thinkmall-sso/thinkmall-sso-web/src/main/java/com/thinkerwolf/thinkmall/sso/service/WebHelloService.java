package com.thinkerwolf.thinkmall.sso.service;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.thinkerwolf.thinkmall.common.OpResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WebHelloService {

    private static final String HELLO_URL = "http://thinkmall-sso-service/hello?name={1}";

    private static final String HELLOS_URL = "http://thinkmall-sso-service/hellos?names={1}";
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
//    @CacheResult(cacheKeyMethod = "getCacheKeyByName")
    public OpResult hello(@CacheKey("name") String name) {
        ResponseEntity<OpResult> re = restTemplate.getForEntity(HELLO_URL, OpResult.class, name);
        return re.getBody();
    }

    @HystrixCommand
    public List<OpResult> hellos(List<String> names) {
        ResponseEntity<List> re = restTemplate.getForEntity(HELLOS_URL, List.class, StringUtils.join(names, ","));
        return re.getBody();
    }

    /**
     * 自定义CacheKey生成方法
     * {@link com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult#cacheKeyMethod()}
     *
     * @param name
     * @return
     */
    public String getCacheKeyByName(String name) {
        return "cache_" + name;
    }

    /**
     * Hystrix降级方法
     *
     * @param name 原始参数
     *             ====================================
     * @param e    导致服务降级的异常
     * @return
     */
    public OpResult helloFallback(String name, Throwable e) {
        e.printStackTrace();
        return OpResult.fail("服务宕机");
    }


    /**
     * Hystrix内部定义
     *
     * @param name
     * @return
     */
    public OpResult hello1(final String name) {
        com.netflix.hystrix.HystrixCommand.Setter setter = com.netflix.hystrix.HystrixCommand.Setter
                .withGroupKey(
                        HystrixCommandGroupKey.Factory.asKey(getClass().getSimpleName()))
                .andCommandKey(HystrixCommandKey.Factory.asKey("hello1"));
        return new com.netflix.hystrix.HystrixCommand<OpResult>(setter) {
            @Override
            protected OpResult run() throws Exception {
                ResponseEntity<OpResult> re = restTemplate.getForEntity(HELLO_URL, OpResult.class, name);
                return re.getBody();
            }

            @Override
            protected OpResult getFallback() {
                return OpResult.fail("sso服务链接不上");
            }

            @Override
            protected String getCacheKey() {
                return name;
            }
        }.execute();
    }
}
