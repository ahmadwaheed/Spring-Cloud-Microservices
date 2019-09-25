package com.spring.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service", url="localhost://8000")

//We dont need to give URL when we add RibbonClient because now we have to distribute
//the load among different Instances and we will configure
//it in application.properties
//@FeignClient(name="currency-exchange-service")

//we dont have to connect to name=currency-exchange-service anymore
//because we are executing our request through Zuul API Gateway
// so we have to mention that 
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	//Have to append 'currency-exchange-service' in the URI
	//	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue
			(@PathVariable("from") String from, @PathVariable("to") String to);
}
  
