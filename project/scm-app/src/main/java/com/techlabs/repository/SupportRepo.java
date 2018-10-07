package com.techlabs.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.Module;
import com.techlabs.entity.Service;

@Repository
public class SupportRepo {

	@Autowired
	private SessionFactory factory;

	public List<Service> GetAllSupportService() {
		List<Service> supportservice = null;
		Session hbsession = factory.openSession();
		hbsession.beginTransaction();
		Criteria criteria = hbsession.createCriteria(Service.class);
		supportservice = criteria.list();
		hbsession.getTransaction().commit();

		return supportservice;

	}

	public Service getServiceById(long service_id) {
		Session hbsession = factory.openSession();
		hbsession.beginTransaction();
		Query query = hbsession
				.createQuery("FROM Service WHERE service_id=:id");
		query.setParameter("id", service_id);
		Service service = (Service) query.uniqueResult();
		hbsession.getTransaction().commit();
		hbsession.close();
		return service;

	}

	public SessionFactory getFactory() {
		return factory;
	}

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
