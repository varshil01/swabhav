package com.techlabs.repo;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.Account;

@Repository
public class AccountRepository {

	@Autowired
	private SessionFactory factory;

	public void createAccount(Account account) {
		Session hbsession = factory.openSession();
		hbsession.beginTransaction();
		hbsession.save(account);
		hbsession.getTransaction().commit();
	}

	public Account getAccountByAcc_no(long acc_no){
		Session hbsession = factory.openSession();
		hbsession.beginTransaction();
		Query query=(Query) hbsession.createQuery("FROM Account WHERE acc_no=:num");
		query.setParameter("num", acc_no);
		Account account=(Account) query.uniqueResult();
		System.out.println("Get Account by acc_no"+account);
		hbsession.getTransaction().commit();
		return account;
	}
	
	public void updateBalanceByAcc_no(Account account){
		Session hbsession = factory.openSession();
		hbsession.beginTransaction();
		hbsession.update(account);
		hbsession.getTransaction().commit();
		hbsession.close();
	}
	public SessionFactory getFactory() {
		return factory;
	}

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
