package com.revature.dao;

import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.revature.model.Employee;

public class MailDAO {
	public static void sendHolidaysReport(String subject, String content) {
		try {
			HtmlEmail email = new HtmlEmail();
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("itsmesentamil@gmail.com", "pass"));
			email.setDebug(false);
			email.setHostName("smtp.gmail.com");
			email.setFrom("itsmesentamil@gmail.com");
			email.setSubject(subject);
			email.setHtmlMsg(content);
			EmployeeDAO employeeDao = new EmployeeDAO();
			List<Employee> mail = employeeDao.getAllEmployeeEmail();
			for (Employee m : mail) {
				email.addTo(m.getEmail());
			}

			email.setTLS(true);
			email.send();
			System.out.println("Mail sent!");
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	public static void sentApprovedLeave(String subject, String content) {
		try {
			HtmlEmail email = new HtmlEmail();
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("itsmesentamil@gmail.com", "pass"));
			email.setDebug(false);
			email.setHostName("smtp.gmail.com");
			email.setFrom("itsmesentamil@gmail.com");
			email.setSubject(subject);
			email.setHtmlMsg(content);
			EmployeeDAO employeeDao = new EmployeeDAO();
			List<Employee> mail = employeeDao.getApprovedEmail(2);
			for (Employee m : mail) {
				email.addTo(m.getEmail());
			}

			email.setTLS(true);
			email.send();
			System.out.println("Mail sent!");
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
