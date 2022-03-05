package com.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.currencyexchangeservice.entities.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
	
	//findBy is always used U and I is capital and name matches with entity that is usd and ind
	//this method go to the database and find out the exchange 
	CurrencyExchange findByUsdAndInd(String from,String to);
	
	

}
