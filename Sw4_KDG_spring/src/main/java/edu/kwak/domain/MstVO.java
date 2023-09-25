package edu.kwak.domain;

import lombok.Data;

@Data
public class MstVO {
	private String code;
	private String pname;
	private Integer cost;
	private Integer pnum;
	private Integer jnum;
	private Integer sale;
	private String gcode;
	private String gname;
	private String ogcode;
	private Integer priority;
	private Integer benefit;
	private Integer gsum;
}
