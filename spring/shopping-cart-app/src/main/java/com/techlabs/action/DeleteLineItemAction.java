package com.techlabs.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.model.LineItem;
import com.techlabs.service.LineItemService;

public class DeleteLineItemAction extends ActionSupport implements SessionAware {
	private LineItemService lineitemservice = new LineItemService();
	private SessionMap<String, Object> sessionmap;

	@SuppressWarnings("unchecked")
	@Override
	public String execute() {
		long id = Long.parseLong(ServletActionContext.getRequest()
				.getParameter("id"));


		List<LineItem> listfromsession = (List<LineItem>) sessionmap
				.get("listoflineitem");
		
		List<LineItem> updatedlistfromsession = lineitemservice.deleteLineItemById(
				listfromsession, id);
		
		sessionmap.put("listoflineitem", updatedlistfromsession);

		
		return "success";
	}

	public LineItemService getLineitemservice() {
		return lineitemservice;
	}

	public void setLineitemservice(LineItemService lineitemservice) {
		this.lineitemservice = lineitemservice;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		sessionmap = (SessionMap<String, Object>) session;

	}

}