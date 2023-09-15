package edu.kwak.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.kwak.domain.TodoVO;
import edu.kwak.mapper.TodoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Service
public class TodoServiceImpl implements TodoService {
	
	private TodoMapper tm;

	@Override
	public List<TodoVO> getList() {
		log.info("====================getList=========================");
		return tm.getList();
	}

	@Override
	public List<TodoVO> todayTodo() {
		log.info("====================todayTodo=========================");
		return tm.todayList();
	}

	@Override
	public Long count() {
		log.info("====================Count=========================");
		return tm.count();
	}

	@Override
	public boolean inputTodo(TodoVO vo) {
		log.info("====================inputTodo=========================");
		return tm.insert(vo) == 1 ? true : false;
	}

}
