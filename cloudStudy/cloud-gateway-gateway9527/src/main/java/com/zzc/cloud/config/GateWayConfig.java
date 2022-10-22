package com.zzc.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zzc0101
 * @date : 2022-10-16 17:58
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator1(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_zzc",
                r -> r.path("/shop")
                        .uri("http://www.mi.com/")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_zzc1",
                r -> r.path("/iphone")
                        .uri("http://www.apple.com.cn/")).build();
        return routes.build();
    }
}
