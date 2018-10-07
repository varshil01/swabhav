package com.techlabs.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.entity.Contact;
import com.techlabs.repository.ContactRepo;

@Service("contactservice")
public class ContactService {

	@Autowired
	private ContactRepo contact_repo;

	public void saveTenantContact(Contact contact) {
		this.contact_repo.saveTenantContact(contact);
	}

	public int generateContactId() {
		return (int) (Math.random()*100000);
	}
	public boolean CheckContactExist(long contact_no){
		return this.CheckContactExist(contact_no);
	}

	public ContactRepo getContact_repo() {
		return contact_repo;
	}

	@Autowired
	public void setContact_repo(ContactRepo contact_repo) {
		this.contact_repo = contact_repo;
	}

}
