package com.spring.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

//1. Type of Entity it manages 2. Type of ID
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	//we have to provide Query methods
	ExchangeValue findByFromAndTo(String from, String to);
	
}
