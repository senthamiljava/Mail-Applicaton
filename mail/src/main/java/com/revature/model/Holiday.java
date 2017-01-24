package com.revature.model;

import java.sql.Date;

import lombok.Data;
@Data
public class Holiday {
	private Long id;
	private Date holidayDate;
	private String status;
}
