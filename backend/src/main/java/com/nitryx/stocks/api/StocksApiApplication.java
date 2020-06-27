package com.nitryx.stocks.api;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.nitryx.stocks.api.domain.model.Stock;
import com.nitryx.stocks.api.domain.model.repository.CompanyRepository;
import com.nitryx.stocks.api.domain.model.repository.StockRepository;

@SpringBootApplication
public class StocksApiApplication {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(StocksApiApplication.class)
				.web(WebApplicationType.SERVLET).run(args);
		
		//Populate Table

		StockRepository stockRepository = applicationContext.getBean(StockRepository.class);
		CompanyRepository companyRepository = applicationContext.getBean(CompanyRepository.class);
		
		Calendar dStart = Calendar.getInstance(); 
		dStart.add(Calendar.DAY_OF_YEAR, -30);
		Calendar cEnd = Calendar.getInstance(); 
		long startTime = 0;			
		for(int i=1; i<=3;i++) {
			startTime = System.currentTimeMillis();
			Long companyId = Long.parseLong(String.valueOf(i));
			while (dStart.get(Calendar.DAY_OF_YEAR)<= cEnd.get(Calendar.DAY_OF_YEAR)) {
				if(Calendar.getInstance().get(Calendar.DAY_OF_YEAR) == dStart.get(Calendar.DAY_OF_YEAR) 
						& Calendar.getInstance().get(Calendar.HOUR_OF_DAY)<= dStart.get(Calendar.HOUR_OF_DAY) 
						& dStart.get(Calendar.HOUR_OF_DAY) <= 18 && dStart.get(Calendar.HOUR_OF_DAY)>=10) {

					Stock currentstock = new Stock();
					currentstock.setPriceDate(dStart);
					currentstock.setPrice(new BigDecimal(10));
					currentstock.setCompany(companyRepository.findById(companyId).get());
					System.out.println("Time: " + currentstock.getPriceDate().getTime() + "price:" + currentstock.getPrice());
					stockRepository.save(currentstock);
				
				
				}
				
				else if(dStart.get(Calendar.HOUR_OF_DAY)>=10 & dStart.get(Calendar.HOUR_OF_DAY)<18) {
					
					Stock currentstock = new Stock();
					currentstock.setPriceDate(dStart);
					currentstock.setPrice(new BigDecimal(10));
					currentstock.setCompany(companyRepository.findById(companyId).get());
					System.out.println("Time: " + currentstock.getPriceDate().getTime() + "price:" + currentstock.getPrice());
					stockRepository.save(currentstock);
					//
			
			}
				dStart.add(Calendar.MINUTE, 1);
			}
		dStart.add(Calendar.DAY_OF_YEAR, -30);
		
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Execution Time: " + (endTime - startTime)/1000 + " seconds");
}
}



