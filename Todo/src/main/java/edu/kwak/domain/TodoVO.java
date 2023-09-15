package edu.kwak.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TodoVO {
	private Long no;
	private String title;
	private Date duedate;
}
