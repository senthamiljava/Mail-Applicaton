package com.revature.dao;

import java.io.StringWriter;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import com.revature.model.Holiday;

public class TestEmail {

	public static void main(String[] args) {
		// try {
		// VelocityEngine ve = new VelocityEngine();
		// ve.init();
		// VelocityContext context = new VelocityContext();
		// Template t =
		// ve.getTemplate(".src/test/java/com/revature/dao/msg.vm");
		// EmployeeDAO employeeDao = new EmployeeDAO();
		// List<Employee> mail = employeeDao.getApprovedEmail(2);
		// for (Employee m : mail) {
		// context.put("NAME", m.getName());
		// StringWriter writer = new StringWriter();
		// t.merge(context, writer);
		// String msg = writer.toString();
		// MailDAO.sendHolidaysReport("Leave Status", msg);
		// }
		// } catch (Exception e) {
		// System.out.println(e);
		// }

		HolidayDAO holidaysDAO = new HolidayDAO();
		List<Holiday> list = holidaysDAO.holidaysList();
		for (Holiday h : list) {
			System.out.println(h);
		}
		try {
			VelocityEngine ve = new VelocityEngine();
			ve.init();
			VelocityContext context = new VelocityContext();
			Template t = ve.getTemplate("./src/test/java/com/revature/dao/holiday_msg.vm");
			// MailDAO mailDao=new MailDAO();
			// List<Employee> mail=mailDao.getApprovedEmail(2);
			StringWriter writer = new StringWriter();
			context.put("project", "Holidays");
			context.put("PROJECT_REPORT_LIST", list);
			t.merge(context, writer);
			String msg = writer.toString();
			MailDAO.sendHolidaysReport("Holidays Report For 2017.,", msg);
			// for (Employee m : mail) {
			// context.put("NAME", m.getName());
			// }
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
