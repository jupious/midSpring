package org.zerock.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.Total;
import org.zerock.service.BoardService;
import org.zerock.service.CommentService;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.Post;

@Log4j
@RestController
@AllArgsConstructor
@RequestMapping("/myapi")
public class MyAPIController {
	
	private CommentService cs;
	private BoardService bs;
	
	@GetMapping(value = "/replybnocount")
	public String postHaveComm() {
		
		return cs.postHaveComm();
	}
	
	@PutMapping(value = "/bestbno", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String commRank() {

		return "{\"bno\":"+cs.commRank()+"}";
	}
	
	@GetMapping(value = "/{num1}/{num2}")
	public Total sum(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
		int count = 0;
		for (int i = num1; i<= num2;i++) {
			count += i;
		}
		Total total = new Total();
		total.setCount(count);
		return total;
	}
	
	@GetMapping(value = "/board/{page}/{amount}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public List<BoardVO> boardList(@PathVariable("page") int pageNum, @PathVariable("amount") int amount) {
		Criteria cri = new Criteria(pageNum, amount);
		return bs.getList(cri);
	}
	
	@PostMapping(value = "/board/{page}/{amount}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<BoardVO> boardSearch(@PathVariable("page") int pageNum, @PathVariable("amount") int amount, @RequestBody Criteria cri){
		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		return bs.getList(cri);
		
	}
	
	
	
	
}
