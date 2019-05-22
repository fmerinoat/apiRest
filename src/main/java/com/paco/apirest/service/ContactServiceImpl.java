package com.paco.apirest.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paco.apirest.Entity.Contact;
import com.paco.apirest.convert.ContactConvert;
import com.paco.apirest.model.ContactDto;
import com.paco.apirest.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{
	
	
	private static final Log LOG = LogFactory.getLog(ContactServiceImpl.class);
	
	@Autowired
	private ContactConvert converter;
	
	@Autowired
	private ContactRepository contactRepository;
	
	public ContactServiceImpl() {
	}

	@Override
	public List<ContactDto> findAll() {
		List<ContactDto> contactsDto = new ArrayList<ContactDto>();
		List<Contact> contacts = contactRepository.findAll();
		
		for (Contact contact: contacts) {
			contactsDto.add((ContactDto) converter.converto2Dto(contact));
		}
		
		return contactsDto;
	}

	@Override
	public ContactDto create(ContactDto contact) {
		
		LOG.info("ContactServiceImpl create contact: "+contact.toString());
		Contact contacto = converter.convert2Entity(contact);
		
		Contact result = contactRepository.save(contacto);
		LOG.info("ContactServiceImpl create result: "+result.toString());
		
		ContactDto contactDto = converter.converto2Dto(result);
		
		return contactDto;
	}

	@Override
	public ContactDto modify(ContactDto contact) {
		LOG.info("ContactServiceImpl modify contact: "+contact.toString());
		Contact contacto = converter.convert2Entity(contact);
		
		return converter.converto2Dto(contactRepository.save(contacto));
	}

	@Override
	public ResponseEntity<ContactDto> delete(int id) {
		LOG.info("ContactServiceImpl delete id: " + id);
		contactRepository.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
