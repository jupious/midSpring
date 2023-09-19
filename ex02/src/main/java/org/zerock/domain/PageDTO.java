package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	//화면에서 페이지바를 표시하긴 위해 필요한 정보
	private int startPage, endPage;
	private boolean prev,next;
	
	private Criteria cri;
	private Long total;
	
	public PageDTO(Criteria cri, Long total) {
		this.cri = cri;
		this.total = total;
		//진짜 마지막 페이지 ceil - 소수점 올림
		int realEnd = (int) (Math.ceil(total*(1.0)/cri.getAmount()));
		//페이지바의 올림(현재페이지/10) *10 
		endPage = (int) (Math.ceil(cri.getPageNum()/10.0) * 10);
		
		if(endPage > realEnd) {
			endPage = realEnd;
		}
		
		startPage = endPage - 9;
		
		prev = (startPage != 1);
		next = (endPage != realEnd);
	}
}
