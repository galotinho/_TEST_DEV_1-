package com.nitryx.stocks.api.domain.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitryx.stocks.api.domain.model.Stock;
import com.nitryx.stocks.api.domain.model.repository.StockRepository;

@Service
public class StocksService {
	
	@Autowired
	private StockRepository stockRepository;

	public List<Stock>getStocks(String company, int numbersOfHoursUntilNow){
		long startTime = System.currentTimeMillis();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, -numbersOfHoursUntilNow);
		List<Stock> currentList = stockRepository.findByCompanyNameAndPriceDateGreaterThan(company, cal);
		
		for (Stock stock : currentList) {
			 System.out.println("Company: " +stock.getCompany().getName() + " - " + "Price: "+ stock.getPrice() 
			 + " - " + "Date: "+ stock.getPriceDate().getTime());
			}
		System.out.println("Total Quotes: " + currentList.size());
		
		long endTime = System.currentTimeMillis();
		System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds");
		return currentList;
	}
	
	public List<Stock> listAll(){
		return stockRepository.findAll();
	}
	
}
