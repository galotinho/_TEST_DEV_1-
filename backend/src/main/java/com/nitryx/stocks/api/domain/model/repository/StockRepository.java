package com.nitryx.stocks.api.domain.model.repository;


import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitryx.stocks.api.domain.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	List<Stock> findByCompanyNameAndPriceDateGreaterThan(String name, Calendar date);
	
}
