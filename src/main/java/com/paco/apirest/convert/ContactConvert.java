package com.paco.apirest.convert;

import org.springframework.stereotype.Component;

import com.paco.apirest.Entity.Contact;
import com.paco.apirest.model.ContactDto;

@Component
public class ContactConvert implements ModelConvert<Contact, ContactDto> {

	@Override
	public Contact convert2Entity(ContactDto dto) {
		Contact contact = new Contact();
		
		contact.setId(dto.getId());
		contact.setCity(dto.getCity());
		contact.setFirstname(dto.getFirstname());
		contact.setLastname(dto.getLastname());
		contact.setTelephone(dto.getTelephone());
		
		return contact;
	}

	@Override
	public ContactDto converto2Dto(Contact model) {
		
		ContactDto contactDto = new ContactDto();
		contactDto.setId(model.getId());
		contactDto.setFirstname(model.getFirstname());
		contactDto.setCity(model.getCity());
		contactDto.setLastname(model.getLastname());
		contactDto.setTelephone(model.getTelephone());
		
		return contactDto;
	}

	
}
