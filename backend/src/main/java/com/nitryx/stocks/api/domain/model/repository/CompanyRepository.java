package com.nitryx.stocks.api.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitryx.stocks.api.domain.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
