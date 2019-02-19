package com.demo.serviceprovider.web.controllers;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderController {

	private static Logger log = LoggerFactory.getLogger(ServiceProviderController.class);

	@GetMapping("/api/service/{delayInSec}")
	public String service(@PathVariable Integer delayInSec) {
		log.info("service provider {}", delayInSec);

		if (delayInSec > 0) {
			try {
				TimeUnit.SECONDS.sleep(delayInSec);
			} catch (InterruptedException e) {
				log.error("service provider error {}", e);
				return "error happend: " + e.getMessage();
			}
		}
		return "Hello AWS";
	}

}
