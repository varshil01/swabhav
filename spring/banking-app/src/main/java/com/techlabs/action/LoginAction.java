package com.techlabs.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.viewmodel.LoginVM;

public class LoginAction extends ActionSupport implements ModelDriven<LoginVM> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginVM userBean = new LoginVM();

	@Override
	public String execute() {
		return "login";
	}

	public String authenticateUser() {
		return "success";

	}

	@Override
	public LoginVM getModel() {

		return userBean;
	}

}