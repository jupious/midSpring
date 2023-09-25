package edu.kwak.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kwak.domain.MstVO;
import edu.kwak.service.MstService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("*.mst")
@AllArgsConstructor
public class MstController {
	
	private MstService ms;
	
	@GetMapping("mainMenu")
	public void mainMenu() {
		log.info("메인메뉴URL요청~~~~~~~~~~~~~~~");
		
	}
	
	@GetMapping("search")
	public void search(MstVO vo, Model model, String code) {
		log.info("검색화면URL요청~~~~~~~~~~~~~~~");
		model.addAttribute("gnameList",ms.groupList());
		
		if(code != null && !(code.equals(""))) {
			model.addAttribute("result", ms.search(code));
		}
	}
	
	@GetMapping("input")
	public String input(MstVO vo, Model model) {
		log.info("데이터 삽입~~~~~~~~~~~~~~~~~~~~~~");
		String res = ms.insert(vo) ? "insert" : "inserterror";
		model.addAttribute("msg", res);
		System.out.println(res);
		return "alert";
	}
	
	@PostMapping("modify")
	public String modify(MstVO vo, Model model) {
		log.info("데이터 수정~~~~~~~~~~~~~~~~~~~~");
		String res = ms.modify(vo) ? "modify" : "modifyerror";		
		model.addAttribute("msg",res);
		return "alert";
		
	}
	
	@PostMapping("delete")
	public String delete(String code, Model model) {
		log.info("데이터 삭제~~~~~~~~~~~~~~~");
		String res = ms.delete(code) ? "delete" : "deleteerror";
		model.addAttribute("msg", res);
		return "alert";
	}
	
	@GetMapping("productin")
	public void productin(Model model) {
		log.info("데이터 입력화면~~~~~~~~~~~~~");
		model.addAttribute("gnameList",ms.groupList());
	}
	
	@GetMapping("priority")
	public String priority(Model model) {
		log.info("우선생산제품~~~~~~~~~~~~~~~~");
		List<MstVO> list = ms.priority();
		if(list.size() != 0) {
			model.addAttribute("priorityList", list);
			return "priority";
		}else {
			model.addAttribute("msg","listerror");
			return "alert";
		}
	}
	
	@GetMapping("benefit")
	public String benefit(Model model) {
		log.info("이익순위~~~~~~~~~~~~~~~~~~~");
		List<MstVO> list = ms.benefit();
		if(list.size() != 0) {
			model.addAttribute("benefitList", list);
			return "benefit";
		}else {
			model.addAttribute("msg","listerror");
			return "alert";
		}
	}
	
	@GetMapping("remain")
	public String remain(Model model) {
		log.info("재고수량~~~~~~~~~~~~~~");
		List<MstVO> list = ms.jGroup();
		if(list.size() != 0) {
			model.addAttribute("remainList", list);
			return "remain";
		}else {
			model.addAttribute("msg","listerror");
			return "alert";
		}
	}
	
	@GetMapping("productlist")
	public String productlist(Model model) {
		log.info("전체목록~~~~~~~~~~~~~~~~~");
		List<MstVO> list = ms.list();
		if(list.size() != 0) {
			model.addAttribute("productList", list);
			return "productlist";
		}else {
			model.addAttribute("msg","listerror");
			return "alert";
		}
	}
	
}
