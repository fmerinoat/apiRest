package com.paco.apirest.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.fabric.Response;
import com.paco.apirest.model.ContactDto;
import com.paco.apirest.service.ContactService;

@RestController
@RequestMapping("/api")
public class ContactController {
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	@Autowired
	ContactService contactService;
	
	
	public ContactController() {
	}

	

	@GetMapping("/allcontacts")
	public ResponseEntity<List<ContactDto>> checkRest(){
		List<ContactDto> contacts = new ArrayList<ContactDto>();
		contacts = contactService.findAll();
		
		return new ResponseEntity<List<ContactDto>>(contacts, HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity<ContactDto> create(@RequestBody ContactDto contact){
		LOG.info("CONTROLLER create contact: "+contact.toString());
		return new ResponseEntity<ContactDto>( contactService.create(contact), HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<ContactDto> modify(@RequestBody ContactDto contact){
		
		return new ResponseEntity<ContactDto>(contactService.modify(contact), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ContactDto> remove(@PathVariable ("id") int id){
		return contactService.delete(id);
	}
}
