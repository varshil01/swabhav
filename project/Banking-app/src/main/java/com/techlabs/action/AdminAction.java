package com.techlabs.action;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.entity.User;
import com.techlabs.service.UserService;

public class AdminAction extends ActionSupport {
	WebApplicationContext context = WebApplicationContextUtils
			.getRequiredWebApplicationContext(ServletActionContext
					.getServletContext());

	private UserService userservice = (UserService) context
			.getBean("userservice");
	HttpSession session;

	private List<User> listofusers = new ArrayList<User>();

	@Override
	public String execute() throws Exception {

		session = ServletActionContext.getRequest().getSession();

		long acc_no = (long) session.getAttribute("acc_no");
		System.out.println();

		listofusers = userservice.getAllUsers();
		
//		SecretKey seckey = userservice.getSecretEncryptionKey();
//		for (User user : listofusers) {
//			byte[] username = user.getUsername().getBytes();
//			byte[] password = user.getPassword().getBytes();
//
//			user.setUsername(userservice.decryptText(username, seckey));
//			user.setPassword(userservice.decryptText(password, seckey));
//
//		}
		return "success";
	}

	public List<User> getListofusers() {
		return listofusers;
	}

	public void setListofusers(List<User> listofusers) {
		this.listofusers = listofusers;
	}

}
