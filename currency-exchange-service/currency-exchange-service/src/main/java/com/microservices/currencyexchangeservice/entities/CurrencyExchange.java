package com.microservices.currencyexchangeservice.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {
	
	@Id
	private Long id;
	@Column(name="currency_from")
	private String usd;
	@Column(name="currency_to")
	private String ind;
	private BigDecimal conversionMultiple;
	private String environment;
	public CurrencyExchange() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CurrencyExchange(Long id, String usd, String ind, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.usd = usd;
		this.ind = ind;
		this.conversionMultiple = conversionMultiple;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsd() {
		return usd;
	}
	public void setUsd(String usd) {
		this.usd = usd;
	}
	public String getInd() {
		return ind;
	}
	public void setInd(String ind) {
		this.ind = ind;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	

}
