package edu.kwak.mapper;

import java.util.List;

import edu.kwak.domain.TodoVO;

public interface TodoMapper {
	//전체 목록
	List<TodoVO> getList();
	
	//오늘날짜 목록
	List<TodoVO> todayList();
	
	//전체 할일 수
	Long count();
	
	//일정 입력
	int insert(TodoVO vo);
}
