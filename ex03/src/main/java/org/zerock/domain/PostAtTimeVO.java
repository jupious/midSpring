package org.zerock.domain;



import lombok.Data;


@Data
public class PostAtTimeVO {

	private Integer time;

	private Long count;
	
	private String day;
}
