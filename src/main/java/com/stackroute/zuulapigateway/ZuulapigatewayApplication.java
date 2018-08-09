package com.stackroute.zuulapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.stackroute.zuulapigateway.filters.ErrorFilter;
import com.stackroute.zuulapigateway.filters.PostFilter;
import com.stackroute.zuulapigateway.filters.PreFilter;
import com.stackroute.zuulapigateway.filters.RouteFilter;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulapigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulapigatewayApplication.class, args);
	}
	@Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }

	@Bean
	public RouteFilter routeFilter() {
        return new RouteFilter();
    }
}
