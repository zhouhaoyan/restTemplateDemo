package com.ibm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;


/**
 * Created by zhouhaoyan on 2017/4/26.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class App extends SpringBootServletInitializer {


    //初始化生成bean实例，controller中使用，restTemplate和controller变量名一致
    //类同：private RestTemplate restTemplate =new RestTemplate();
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
