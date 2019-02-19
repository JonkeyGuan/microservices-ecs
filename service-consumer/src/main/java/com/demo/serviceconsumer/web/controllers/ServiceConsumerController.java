package com.demo.serviceconsumer.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.serviceconsumer.services.ServiceProviderFeignClient;

@RestController
public class ServiceConsumerController {

	private static Logger log = LoggerFactory.getLogger(ServiceConsumerController.class);

	@Autowired
	private ServiceProviderFeignClient ServiceProvider;

	@GetMapping("/api/service/{delayInSec}")
	public String service(@PathVariable Integer delayInSec) {
		log.info("service consumer {}", delayInSec);
		return ServiceProvider.service(delayInSec);
	}

//	@GetMapping({ "/api/service", "/api/service/{delayInSec}" })
//	public String service(@PathVariable Optional<Integer> delayInSec) {
//		log.info("service provider {}", delayInSec.isPresent() ? delayInSec.get() : "");
//
//		if (delayInSec.isPresent() && delayInSec.get() > 0) {
//			try {
//				TimeUnit.SECONDS.sleep(delayInSec.get());
//			} catch (InterruptedException e) {
//				log.error("service provider error {}", e);
//				return "error happend: " + e.getMessage();
//			}
//		}
//		return "Hello AWS";
//	}
}
