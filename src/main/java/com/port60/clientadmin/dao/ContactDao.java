package com.port60.clientadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.port60.clientadmin.model.Contact;

public interface ContactDao extends JpaRepository<Contact, Long>{

}
