package com.revature.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Holiday;
import com.revature.util.ConnectionUtil;

public class HolidayDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public List<Holiday> holidaysList() {
		String sql = "SELECT HOLIDAY_DATE,REASON FROM HOLIDAYS";

		List<Holiday> list = jdbcTemplate.query(sql, (rse, rows) -> {
			Holiday holidays = new Holiday();
			holidays.setHolidayDate(rse.getDate("HOLIDAY_DATE"));
			holidays.setStatus(rse.getString("REASON"));
			return holidays;
		});
		return list;
	}
}
