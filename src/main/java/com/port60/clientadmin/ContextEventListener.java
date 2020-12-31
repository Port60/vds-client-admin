package com.port60.clientadmin;

import com.google.i18n.phonenumbers.PhoneNumberUtil;

import com.port60.clientadmin.dao.CountryDao;
import com.port60.clientadmin.model.Country;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.Locale;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@AllArgsConstructor
@Component
public class ContextEventListener implements ApplicationListener<ContextRefreshedEvent>{

  private CountryDao countryDao;



  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {

    if(Optional.ofNullable(countryDao.findCountryByIsoCountryCodeEquals(Locale.UK.getCountry()) ).isEmpty()) {
      Country country = new Country();
      country.setIsoCountryCode(Locale.UK.getCountry());
      Currency currency = Currency.getInstance(Locale.UK);
      country.setIsoCurrencyCode(currency.getCurrencyCode());
      country.setIsoLanguageCode(Locale.UK.getLanguage());
      country.setName(Locale.UK.getDisplayCountry());
      country.setIsoCallingCode(String
          .valueOf(PhoneNumberUtil.getInstance().getCountryCodeForRegion(Locale.UK.getCountry())));
      country.setCreated(LocalDateTime.now());
      country.setCreatedByUser("SYSTEM");
      country.setLastModified(LocalDateTime.now());
      country.setLastUpdatedByUser("SYSTEM");
      countryDao.save(country);

    }
  }
}
