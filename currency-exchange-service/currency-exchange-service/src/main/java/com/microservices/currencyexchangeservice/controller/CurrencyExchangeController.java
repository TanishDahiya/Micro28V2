package com.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyexchangeservice.entities.CurrencyExchange;
import com.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository cer;
	
	@Autowired
	private Environment env;
	
	//from-->USD  to-->INR
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
//		CurrencyExchange currencyExchange = new CurrencyExchange(1000L,from,to,BigDecimal.valueOf(50));
		CurrencyExchange currencyExchange=cer.findByUsdAndInd(from, to);
		
		//check whether exchange is exist or not. We have only 3 exchnages USD to IND, AUD to IND, EUR to IND
		if(currencyExchange==null) {
			throw new RuntimeException("Unable to find data"+ from+"to"+ to);
		}
		//This is for fetching the port we use enviornment a interface method
		String port=env.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;

	}

}
