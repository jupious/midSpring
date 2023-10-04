package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CommentVO {
	private Long bno;
	private String text;
	private String writer;
	private Date commdate;
	private Long cno;
	private Date commupdate;
}
