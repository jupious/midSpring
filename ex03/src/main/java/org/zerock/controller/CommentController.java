package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.CommentVO;
import org.zerock.service.CommentService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@AllArgsConstructor
@RequestMapping("/comments")
public class CommentController {
	private CommentService cs;
	
	@PostMapping(value = "/new", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> regComm(@RequestBody CommentVO vo){
		log.info(vo);
		return cs.regComm(vo) ? new ResponseEntity<>("regSuccess", HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/pages/{bno}")
	public List<CommentVO> commList(@PathVariable("bno") Long bno){
		return cs.getComm(bno);
	}
	
	@DeleteMapping(value = "/{cno}")
	public ResponseEntity<String> removeComm(@PathVariable("cno") Long cno){
		return cs.delComm(cno) ? new ResponseEntity<>("deleteSuccess",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value = "/{cno}")
	public ResponseEntity<String> modComm(@RequestBody CommentVO vo){
		log.info(vo);
		return cs.upComm(vo) ? new ResponseEntity<>("modSuccess", HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
