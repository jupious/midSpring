package edu.kwak.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PostVO {
	private Long pno;
	private String title;
	private String nickname;
	private Date postdate;
	private String content;
}
