package com.techlabs.entity.test;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.techlabs.entity.Account;
import com.techlabs.entity.Customer;

public class EntityTest {
	public static void main(String args[]) {
		Customer cust1 = new Customer(101, "varshil", "virar");
		Customer cust2 = new Customer(102, "xyz", "borivali");
		Customer cust3 = new Customer(103, "manoj", "andheri");

		Account acc1 = new Account(Math.abs(UUID.randomUUID().getMostSignificantBits()),
				"saving", 252000);
		Account acc2 = new Account(UUID.randomUUID().getMostSignificantBits(),
				"saving", 2556000);
		Account acc3 = new Account(UUID.randomUUID().getMostSignificantBits(),
				"saving", 2524500);

		cust1.setAccount(acc1);
		
		cust2.setAccount(acc2);
		cust3.setAccount(acc3);
		try {
			Configuration config = new Configuration();
			config.configure("hibernate-cfg.xml");
			SessionFactory factory = config.buildSessionFactory();
			Session hbsession = factory.getCurrentSession();
			hbsession.beginTransaction();
			hbsession.save(cust1);
			hbsession.save(acc1);
			hbsession.save(cust2);
			hbsession.save(cust3);
			hbsession.save(acc1);
			hbsession.save(acc2);
			hbsession.save(acc3);
			hbsession.getTransaction().commit();
			factory.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
}
