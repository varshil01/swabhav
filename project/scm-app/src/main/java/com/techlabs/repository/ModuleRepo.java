package com.techlabs.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.Module;

@Repository
public class ModuleRepo {

	@Autowired
	private SessionFactory factory;

	public List<Module> GetAllModules() {
		List<Module> modules = null;
		Session hbsession = factory.openSession();
		hbsession.beginTransaction();

		Criteria criteria = hbsession.createCriteria(Module.class);
		modules = criteria.list();
		hbsession.getTransaction().commit();
hbsession.close();
		return modules;

	}

	public Module getModuleById(long module_id) {
		Session hbsession = factory.openSession();
		hbsession.beginTransaction();
		Query query = hbsession.createQuery("FROM Module WHERE module_id=:id");
		query.setParameter("id", module_id);
		Module module = (Module) query.uniqueResult();
		hbsession.getTransaction().commit();
		hbsession.close();
		return module;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
