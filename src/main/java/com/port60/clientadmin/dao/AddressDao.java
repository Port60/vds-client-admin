package com.port60.clientadmin.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.port60.clientadmin.model.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressDao extends JpaRepository<Address, Long>{

  @Query("select a from Address a where lower(a.postcode) = :postCode and  lower(a.addressLine1)=:addressline1")
  List<Address> findAddressByPostcodeAndAddressLine1Equals(@Param("postCode") String postcode, @Param("addressline1") String addressLine1);


}
