package com.techlabs.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.User;

@Repository
public class UserRepo {
	@Autowired
	private SessionFactory factory;

	public boolean AuthenticateUser(User user){
		Session hbsession=factory.openSession();
		hbsession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User> listofusers=hbsession.createCriteria(User.class).list();
		for(User eachuser:listofusers){
			if((eachuser.getUsername().equals(user.getUsername()))&& eachuser.getPassword().equals(user.getPassword()) ){
				System.out.println("true");
				return true;
			}
		}
		hbsession.getTransaction().commit();
		System.out.println("false");
		return false;
		
	}
	public boolean checkUserExists(String username){
		Session hbsession=factory.openSession();
		hbsession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User> listofusers=hbsession.createCriteria(User.class).list();
		if(listofusers.isEmpty()){
			
			return false;
		}
		for(User eachuser:listofusers){
			if(eachuser.getUsername().equals(username) ){
				System.out.println("true");
				return true;
			}
		}
		hbsession.getTransaction().commit();
		System.out.println("false");
		return false;
		
	}
	public void registerUser(User user){
		Session hbsession=factory.openSession();
		hbsession.beginTransaction();
		hbsession.save(user);
		hbsession.getTransaction().commit();
	}
	public SessionFactory getFactory() {
		return factory;
	}

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	
}
