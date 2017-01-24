package com.revature.util;

import org.springframework.jdbc.core.JdbcTemplate;

public class TestConnectionUtil {

	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
		System.out.println(jdbcTemplate);

	}

}
