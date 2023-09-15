package edu.kwak.service;

import java.util.List;

import edu.kwak.domain.TodoVO;

public interface TodoService {
	//전체목록
	List<TodoVO> getList();
	//오늘날짜목록
	List<TodoVO> todayTodo();
	//전체 할일 수
	Long count();
	//일정 입력
	boolean inputTodo(TodoVO vo);
}
