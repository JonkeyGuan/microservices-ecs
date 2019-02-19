package com.demo.serviceconsumer.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-provider", fallback = ServiceProviderFeignClientFallback.class, url="${service-provider.url}")
public interface ServiceProviderFeignClient {

	@GetMapping("/api/service/{delayInSec}")
	public String service(@PathVariable Integer delayInSec);
}

@Component
final class ServiceProviderFeignClientFallback implements ServiceProviderFeignClient {

	@Override
	public String service(Integer delayInSec) {
		return "Error";
	}

}