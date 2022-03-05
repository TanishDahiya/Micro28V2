package com.microservices.currencyconversionservice.proxy;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.currencyconversionservice.entities.CurrencyConversion;

//name is matched to the application name of other service
//@FeignClient(name="currency-exchange",url="localhost:8080")
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
	
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to
			) ;

}
