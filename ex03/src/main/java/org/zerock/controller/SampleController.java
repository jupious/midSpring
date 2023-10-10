package org.zerock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController //data로 응답하는 컨트롤러
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE: " +MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	@GetMapping(value = "/getSample", produces = MediaType.APPLICATION_JSON_VALUE)
	public SampleVO getSample() {
		SampleVO vo = new SampleVO(1, "오늘은", "수요일");
		
		return vo;
	}
	
	@GetMapping(value = "/getSampleXML")
	public SampleVO getSampleXML() {
		SampleVO vo = new SampleVO(1, "오늘은", "수요일");
		
		return vo;
		//json 변환라이브러리만 있으면 json으로
		//xml 변환라이브러리만 있으면 xml로
		//둘다있으면 xml로
		//url뒤에 .json으로하면 json으로 .xml로 하면 xml로 처리된다
	}
	
	@GetMapping("/getList")
	public List<SampleVO> getList(){
//		List<SampleVO> list = new ArrayList<>();
//		for(int i = 0; i < 10 ;i++) {
//			SampleVO vo = new SampleVO(i, i+"성", i+"이름");
//			list.add(vo);
//		}
//		return list;
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i+"람다성", i+"람다이름")).collect(Collectors.toList());
	}
	
	@GetMapping("/getMap")
	public Map<String, SampleVO> getMap(){
		Map<String,SampleVO> map = new HashMap<>();
		map.put("Key1", new SampleVO(1,"해시맵1","해시맵2"));
		return map;
	}
								  //특정 기값이 존재하게 제한(값이 없으면 400에러)
	@GetMapping(value = "/check", params = {"height", "weight"})
	public ResponseEntity<SampleVO> check(int height, int weight){
		SampleVO vo = new SampleVO(1, ""+height, ""+weight );
		
		return height < 150 ? ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo) : ResponseEntity.status(HttpStatus.OK).body(vo);
	}
	
	//p366 url에 있는 값 읽는법
	// /sample/product/원하는글자/원하는숫자
	// /sample/product/bags/100
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] product(@PathVariable("cat") String cate, @PathVariable("pid") Integer id) {
		return new String[] {"category: "+cate, "productid: "+id};
	}
	
	//보낸 데이터를 읽는법
	
	@PostMapping("/ticket")
	public SampleVO ticket(@RequestBody SampleVO vo) {
		log.info("vo = "+vo);
		return vo;
	}
	
	@GetMapping(value = "/getText1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getText1() {
		log.info("MIME TYPE: " +MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
}
