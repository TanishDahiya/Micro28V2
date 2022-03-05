package com.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.currencyconversionservice.entities.CurrencyConversion;
import com.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy cep;
	//http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
	
//first method fetching other service using rest template
	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		
		//Create Hashmap for Urivariables
		HashMap<String, String> urivariables=new HashMap<String, String>();
		urivariables.put("from", from);
		urivariables.put("to", to);
		
		ResponseEntity<CurrencyConversion> responseEntity=new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,urivariables);
		CurrencyConversion cc = responseEntity.getBody();
		
				return new CurrencyConversion(cc.getId(),from,to,quantity,cc.getConversionMultiple(),quantity.multiply(cc.getConversionMultiple()),cc.getEnvironment());
		
	}
	
	
	//2nd method using cloud feign client
	
	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		

		CurrencyConversion cc=cep.retrieveExchangeValue(from, to);
		
		return new CurrencyConversion(cc.getId(),from,to,quantity,cc.getConversionMultiple(),quantity.multiply(cc.getConversionMultiple()),cc.getEnvironment());
		
	}

}
