package com.paco.apirest.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.paco.apirest.model.ContactDto;

public interface ContactService {
	
	public List<ContactDto> findAll();
	public ContactDto create(ContactDto contact);
	public ContactDto modify(ContactDto contact);
	public ResponseEntity<ContactDto> delete(int id);
}
