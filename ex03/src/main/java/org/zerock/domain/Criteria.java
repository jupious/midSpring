package org.zerock.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	//페이지 처리를 위한 정보 + 검색정보
	//페이지 번호, 페이지당 보여줄 개수
	//검색할 요소(type) C-content T-title w-writer / D-comments
	//검색어 (keyword)
	private int pageNum;
	private int amount;
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	//type 글자를 하나씩 자르는 메소드
	public String[] getTypeArr() {	//typeArr 게터와 동일하게 사용가능 ex) #{typeArr}로 사용가능
		//타입이 널이 아니면 한글자씩 잘라서 리턴 널이면 빈배열 리턴
		return (type!=null) ? type.split("") : new String[] {};
	
		
	}
}
