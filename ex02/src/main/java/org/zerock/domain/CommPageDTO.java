package org.zerock.domain;

import lombok.Data;

@Data
public class CommPageDTO {
	//화면에서 페이지바를 표시하긴 위해 필요한 정보
		private int startPage, endPage;
		private int cpNum;
		private int camount;
		private boolean prev,next;
		private Long bno;
		
		private Long total;
		
		public CommPageDTO() {
			this(2457651L,1,5,15L);
		}
		
		
		public CommPageDTO(Long bno, int cpNum, int camount, Long total) {
			this.bno = bno;
			this.cpNum = cpNum;
			this.camount = camount;
			this.total = total;
			//진짜 마지막 페이지 ceil - 소수점 올림
			int realEnd = (int) (Math.ceil(total*(1.0)/camount));
			//페이지바의 올림(현재페이지/10) *10 
			endPage = (int) (Math.ceil(cpNum/10.0) * 10);
			
			if(endPage > realEnd) {
				endPage = realEnd;
			}
			
			startPage = endPage - 9;
			if(startPage < 1)
				startPage = 1;
			
			prev = (startPage != 1);
			next = (endPage != realEnd);
		}
}
