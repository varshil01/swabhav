package com.techlabs.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.entity.UserTransaction;
import com.techlabs.service.UserTransactionService;

public class DownloadTransaction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	WebApplicationContext context = WebApplicationContextUtils
			.getRequiredWebApplicationContext(ServletActionContext
					.getServletContext());

	private UserTransactionService transactionservice = (UserTransactionService) context
			.getBean("transactionservice");
	HttpSession session;
	HttpServletResponse response;

	@Override
	public String execute() throws IOException {
		session = ServletActionContext.getRequest().getSession();
		long acc_no = (long) session.getAttribute("acc_no");
		List<UserTransaction> transactions = transactionservice
				.getAllTransaction(acc_no);

		response = ServletActionContext.getResponse();
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition",
				"attachment; filename=\"passbook.csv\"");

		for (UserTransaction transaction : transactions) {
			String transactionincsv=getEachTransactionInCSV(transaction);
			response.getOutputStream().print(transactionincsv);
		}

		
		return null;
	}

	public String getEachTransactionInCSV(UserTransaction transaction) {
		String transactionincsv = String.valueOf(transaction
				.getTransaction_id())
				+ ","
				+ transaction.getNarration()
				+ ","
				+ transaction.getTransaction_date().toString()
				+ ","
				+ String.valueOf(transaction.getAmount())
				+ ","
				+ transaction.getTransaction_type()
				+ "\n";
		return transactionincsv;
	}
}
