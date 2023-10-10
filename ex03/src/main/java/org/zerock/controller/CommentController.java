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
	
	//consumes  통해 보내온데이터 타입확인 틀리면  415(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@PostMapping(value = "/new", consumes=MediaType.APPLICATION_JSON_VALUE ,
								 produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> regComm(@RequestBody CommentVO vo){
		log.info(vo);
		return cs.regComm(vo) ? new ResponseEntity<>("success", HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/pages/{bno}")
	public List<CommentVO> commList(@PathVariable("bno") Long bno){
		return cs.getComm(bno);
	}
	
	@DeleteMapping(value = "/{cno}")
	public ResponseEntity<String> removeComm(@PathVariable("cno") Long cno){
		return cs.delComm(cno) ? new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value = "/{cno}")
	public ResponseEntity<String> modComm(@PathVariable("cno") Long cno, @RequestBody CommentVO vo){
		log.info(vo);
		vo.setCno(cno);
		return cs.upComm(vo) ? new ResponseEntity<>("success", HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/{cno}")
	public CommentVO getCno(@PathVariable("cno") Long cno) {
		return cs.get(cno);
	}
	
	@PutMapping(value = "/like/{cno}")
	public ResponseEntity<String> likeIt(@PathVariable("cno") Long cno){
		log.info("여기왔음??"+cno);
		return cs.likeComm(cno) ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}

