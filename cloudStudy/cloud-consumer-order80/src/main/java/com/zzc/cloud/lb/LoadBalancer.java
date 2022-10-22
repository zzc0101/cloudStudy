package com.zzc.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author : zzc0101
 * @date : 2022-09-04 16:09:40
 * @description : 自定义负载均衡接口
 **/
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
