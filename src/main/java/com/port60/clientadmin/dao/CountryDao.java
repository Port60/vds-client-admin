package com.port60.clientadmin.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.port60.clientadmin.model.Country;

public interface CountryDao extends JpaRepository<Country, Long>{


  Country findCountryByNameEquals(String name);

  Country findCountryByIsoCountryCodeEquals(String isoCountryCode);

}
