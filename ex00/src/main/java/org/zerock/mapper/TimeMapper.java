package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;


public interface TimeMapper {
	//시간 가져오기
	
	@Select("select sysdate from dual")
	String getTime();
	//xml로 쿼리 처리
	String getTime2();
}
