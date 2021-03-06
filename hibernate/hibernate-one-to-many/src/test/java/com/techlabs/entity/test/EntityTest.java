package com.techlabs.entity.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.techlabs.entity.Department;
import com.techlabs.entity.Employee;

public class EntityTest {

	public static void main(String args[]) {

		Department comps_dept = new Department();
		Department extc_dept = new Department();
		Department IT_dept = new Department();

		Set<Employee> empset1 = new HashSet<Employee>();
		Set<Employee> empset2 = new HashSet<Employee>();
		Set<Employee> empset3 = new HashSet<Employee>();

		Employee emp1 = new Employee(10001, "varshil", 25000, comps_dept);
		Employee emp2 = new Employee(10002, "manoj", 30000, comps_dept);
		Employee emp3 = new Employee(10003, "varsh", 25000, extc_dept);
		Employee emp4 = new Employee(10004, "manu", 30000, IT_dept);

		empset1.add(emp1);
		empset1.add(emp2);
		empset2.add(emp3);
		empset3.add(emp4);

		comps_dept.setDept_name("computer");
		comps_dept.setEmpSet(empset1);
		comps_dept.setDept_id(101);

		extc_dept.setDept_name("EXTC");
		extc_dept.setEmpSet(empset2);
		extc_dept.setDept_id(102);

		IT_dept.setDept_name("IT");
		IT_dept.setEmpSet(empset3);
		IT_dept.setDept_id(103);

		try {
			Configuration config = new Configuration();
			config.configure("hibernate-cfg.xml");
			SessionFactory factory = config.buildSessionFactory();
			Session hbsession = factory.getCurrentSession();

			hbsession.beginTransaction();

//			hbsession.save(comps_dept);
//			hbsession.save(emp1);
//			hbsession.save(emp2);
//			
//			hbsession.save(extc_dept);
//			hbsession.save(emp3);
//
			hbsession.save(IT_dept);
			hbsession.save(emp4);

			hbsession.getTransaction().commit();
			factory.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
}
