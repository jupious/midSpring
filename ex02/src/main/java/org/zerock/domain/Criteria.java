package org.zerock.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	//페이지 처리를 위한 정보
	//페이지 번호, 페이지당 보여줄 개수
	private int pageNum = 1;
	private int amount = 10;
	
	public Criteria() {	
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
