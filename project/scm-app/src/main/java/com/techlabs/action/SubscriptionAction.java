package com.techlabs.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.entity.Module;
import com.techlabs.entity.Service;
import com.techlabs.entity.Subscription;
import com.techlabs.entity.Tenant;
import com.techlabs.service.ModuleService;
import com.techlabs.service.SubscriptionService;
import com.techlabs.service.SupportService;
import com.techlabs.service.TenantService;

public class SubscriptionAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	WebApplicationContext context = WebApplicationContextUtils
			.getRequiredWebApplicationContext(ServletActionContext
					.getServletContext());

	private SubscriptionService subscriptionservice = (SubscriptionService) context
			.getBean("subscriptionservice");
	private ModuleService moduleservice = (ModuleService) context
			.getBean("moduleservice");
	private SupportService supportservice = (SupportService) context
			.getBean("supportservice");

	private TenantService tenantservice = (TenantService) context
			.getBean("tenantservice");
	private List<Module> modules;
	private List<Service> listofservices;
	private List<String> selectedservices;
	private List<String> selectedmodules;
	private int num_of_user;
	private String selectedtype;

	@Override
	public String execute() {
		System.out.println("coming to subscription action execute method");
		modules = moduleservice.GetAllModules();
		listofservices = supportservice.GetAllSupportService();
		return "success";
	}

	public String saveSubscription() {
		System.out
				.println("\n\ncoming to save subscription method in Subscription action");
		long tenant_id = Long.valueOf(ServletActionContext.getRequest()
				.getParameter("id"));
		System.out.println(tenant_id);
		Tenant tenant = tenantservice.getTenantById(tenant_id);

		String sub_id = String.valueOf(subscriptionservice.generateRandomId());
		Subscription subscription = new Subscription(sub_id, selectedtype, num_of_user,"pending",
				tenant);

		Set<Module> setofmodule = new HashSet<Module>();
		Set<Service> setofservice = new HashSet<Service>();

		for (String module_id : selectedmodules) {
			Module module = moduleservice.getModuleById(Long
					.parseLong(module_id));
			setofmodule.add(module);
		}
		for (String service_id : selectedservices) {
			Service service = supportservice.getSupportServiceById(Long.parseLong(service_id));
			setofservice.add(service);
		}

		subscription.setModules(setofmodule);
		subscription.setServices(setofservice);

		subscriptionservice.saveSubscription(subscription);
		return "success";
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Service> getListofservices() {
		return listofservices;
	}

	public void setListofservices(List<Service> listofservices) {
		this.listofservices = listofservices;
	}

	public List<String> getSelectedservices() {
		return selectedservices;
	}

	public void setSelectedservices(List<String> selectedservices) {
		this.selectedservices = selectedservices;
	}

	public List<String> getSelectedmodules() {
		return selectedmodules;
	}

	public void setSelectedmodules(List<String> selectedmodules) {
		this.selectedmodules = selectedmodules;
	}

	public int getNum_of_user() {
		return num_of_user;
	}

	public void setNum_of_user(int num_of_user) {
		this.num_of_user = num_of_user;
	}

	public String getSelectedtype() {
		return selectedtype;
	}

	public void setSelectedtype(String selectedtype) {
		this.selectedtype = selectedtype;
	}


}
