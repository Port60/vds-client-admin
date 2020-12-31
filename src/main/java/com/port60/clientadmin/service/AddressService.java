package com.port60.clientadmin.service;

import com.port60.clientadmin.dao.AddressDao;
import com.port60.clientadmin.model.Address;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class AddressService {

  private AddressDao addressDao;


  public AddressService(AddressDao addressDao){
    this.addressDao = addressDao;
  }

  @Transactional
  public Address saveAddress(Address address){
    List<Address> existingAddresses = addressDao.findAddressByPostcodeAndAddressLine1Equals(address.getPostcode(),address.getAddressLine1());
    if(!CollectionUtils.isEmpty(existingAddresses) && existingAddresses.size() == 1){
      return existingAddresses.get(0);
    } else if (!CollectionUtils.isEmpty(existingAddresses) ){
      addressDao.save(existingAddresses.stream().filter(a -> a.getAddressLine2().equalsIgnoreCase(address.getAddressLine2()))
          .filter(a -> a.getAddressLine3().equalsIgnoreCase(address.getAddressLine3()))
          .findFirst().orElse(address));
    }
    return addressDao.save(address);
  }
}
