package com.techlabs.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.model.College;
import com.techlabs.model.Student;
import com.techlabs.services.CollegeService;
import com.techlabs.services.StudentService;
import com.techlabs.viewmodel.AddStudentVM;

public class AddStudentAction extends ActionSupport implements
		ModelDriven<AddStudentVM>, GetCollege {
	private String methodtype = "GET";
	private boolean postBack = false;
	private StudentService studentservice = StudentService.getInstanceOf();
	private CollegeService collegeservice = CollegeService.getInstancesOf();
	
	AddStudentVM studentBeam = new AddStudentVM();
	private List<College> listOfColleges;

	@Override
	public String execute() throws Exception {
		listOfColleges=collegeservice.getColleges();
		studentBeam.getCollegeForOption(listOfColleges);
		System.out.println("inside get method");
		return "input";
	}

	public String executePost()throws Exception {
		System.out.println("inside post method");
		studentservice.addStudent(new Student(studentBeam.getRollno(),
				studentBeam.getFname(), studentBeam.getLname(), studentBeam
						.getClg_id(), studentBeam.getCgpi(), studentBeam
						.getGender()));
		return "success";

	}

	public void validate() {
		if (studentBeam.getRollno() < 0) {
			addFieldError("student.fname", "First name is mandatory");
			setMethodtype("GET");
		}

		if (studentBeam.getFname() == "") {
			addFieldError("student.fname", "First name is mandatory");
			setMethodtype("GET");
		}
		if (studentBeam.getLname() == "") {
			addFieldError("student.lname", "Last name is mandatory");
			setMethodtype("GET");
		}
		if ((studentBeam.getCgpi() < 1.0 && studentBeam.getCgpi() > 10.0)) {
			addFieldError("cgpi", "cgpi is mandatory");
			setMethodtype("GET");
		}
	}

	@Override
	public AddStudentVM getModel() {
		return studentBeam;
	}

	public String getMethodtype() {
		return methodtype;
	}

	public void setMethodtype(String methodtype) {
		this.methodtype = methodtype;
	}

	public StudentService getStudentservice() {
		return studentservice;
	}

	public void setStudentservice(StudentService studentservice) {
		this.studentservice = studentservice;
	}

	public AddStudentVM getStudentBeam() {
		return studentBeam;
	}

	public void setStudentBeam(AddStudentVM studentBeam) {
		this.studentBeam = studentBeam;
	}

	@Override
	public void getCollegesForOptions(List<College> listOfColleges) {
		this.listOfColleges = listOfColleges;

	}

	public boolean isPostBack() {
		return postBack;
	}

	public void setPostBack(boolean postBack) {
		this.postBack = postBack;
	}

	public List<College> getListOfColleges() {
		return listOfColleges;
	}

	public void setListOfColleges(List<College> listOfColleges) {
		this.listOfColleges = listOfColleges;
	}

	public CollegeService getCollegeservice() {
		return collegeservice;
	}

	public void setCollegeservice(CollegeService collegeservice) {
		this.collegeservice = collegeservice;
	}
	

}
