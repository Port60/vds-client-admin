package com.port60.clientadmin.service;

import com.port60.clientadmin.dao.ContactDao;
import com.port60.clientadmin.model.Contact;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactService {

  private ContactDao contactDao;

  @Transactional
  public Contact saveContact(Contact contact){
    return contactDao.save(contact);
  }

}
