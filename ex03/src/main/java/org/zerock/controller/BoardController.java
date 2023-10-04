package org.zerock.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.CommentVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;
import org.zerock.service.CommentService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService bs;	//생성자 주입
	private CommentService cs;
	
	@GetMapping("list")
	public void list(Criteria cri, Model model) {
		log.info("========================= list URL요청 =========================");
		model.addAttribute("list",bs.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, bs.count(cri)));
	}
	
	
	@PostMapping("register")	//등록처리(모든항목-BoardVO) board/register(post) <- 입력화면(get)
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("========================= register Post URL요청 =========================");
		bs.register(vo);
		rttr.addFlashAttribute("result", vo.getBno()); //작성된 글번호 한번만 전송
		rttr.addFlashAttribute("status","register success");
		return "redirect:/board/list";	//리다이렉트가 없으면 jsp 있으면 요청
	}
	
	@GetMapping("register")
	public void inputView() {
		log.info("입력화면 요청됨");
	}
	
//	@GetMapping("remove")
//	public void remove(Long bno, Model model, Criteria cri) {
//		model.addAttribute("board", bs.get(bno));
//		model.addAttribute("cri", cri);
//	}
	
	@GetMapping("modify")
	public void modify(Long bno, Model model, Criteria cri) {
		model.addAttribute("board", bs.get(bno));
		model.addAttribute("cri", cri);
	}
	
	
	@GetMapping("get")	//읽기(글번호-bno) board/get(get)
	public void get(Long bno, Model model, Criteria cri) {
		log.info("========================= get URL요청 =========================");
		model.addAttribute("board",bs.get(bno));
		model.addAttribute("cri",cri);
	
		model.addAttribute("commentList",cs.getComm(bno));
	
	}
	
	
	@PostMapping("remove")	//삭제(글번호-bno) board/remove(post) <-입력화면(get)
	public String remove(Long bno, RedirectAttributes rttr, Criteria cri) {
		log.info("========================= remove Post URL요청 =========================");
		if(bs.remove(bno)) {	//이상이 없다면 데이터 전송
			rttr.addFlashAttribute("result", bno);
			rttr.addFlashAttribute("status","remove success");
		}
		return "redirect:/board/list?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount();
	}

	
	
	@PostMapping("modify")	//수정(모든항목-BoardVO) board/modify(post) <-입력화면(get)
	public String modify(BoardVO vo, RedirectAttributes rttr, Criteria cri) {
		log.info("========================= modify Post URL요청 =========================");
		if(bs.modify(vo)) {
			rttr.addFlashAttribute("result", vo.getBno());
			rttr.addFlashAttribute("status","modify success");
		}
		return "redirect:/board/list?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount();
		//return "redirect:/board/get?bno="+vo.getBno();
	}
	
	@GetMapping("charts")
	public void charts(Model model) {
		log.info("========================= charts URL요청 =========================");
		model.addAttribute("list",bs.postCount());
		model.addAttribute("rank",bs.getRank());
		model.addAttribute("rankAll",bs.getRankAll());
		model.addAttribute("avg",bs.getAvg());
		model.addAttribute("dayList",bs.postCountDay());
	}
	
	@PostMapping("regComm")
	public String regComm(CommentVO vo, Criteria cri) {
		cs.regComm(vo);
		return "redirect:/board/get?bno="+vo.getBno()+"&pageNum="+cri.getPageNum()+"&amount="+cri.getAmount();
	}
	
	@PostMapping("delComm")
	public String delComm(Long cno, Criteria cri, RedirectAttributes rttr, Long bno) {
		if(cs.delComm(cno)) {
			rttr.addFlashAttribute("result","댓글 삭제 완료");
		}
		return "redirect:/board/get?bno="+bno+"&pageNum="+cri.getPageNum()+"&amount="+cri.getAmount();
	}
	@GetMapping("dash-board")
	public void dashBoard() {
	}
	

	
}
