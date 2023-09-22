package edu.kwak.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.kwak.domain.MemberVO;
import edu.kwak.domain.PostVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Autowired
	BoardMapper bm;
	
	@Test
	public void testSignUp() {
		MemberVO vo = new MemberVO();
		vo.setName("김민수");
		vo.setId("mskim");
		vo.setPw("1234");
		vo.setNickname("민수르");
		log.info("1이면 가입된거임 " + bm.signUp(vo));
	}
	@Test
	public void testLogin() {
		log.info("1이면 로그인성공 0이면 실패"+bm.login("mssss"));
	}
	
	@Test
	public void testList() {
		bm.list().forEach(x->log.info(x));
	}
	
	@Test
	public void testRead() {
		bm.read(1L);
	}
	
	@Test
	public void testInsert() {
		PostVO vo = new PostVO();
		vo.setTitle("매퍼테스트글삽입");
		vo.setNickname("민수르");
		vo.setContent("매퍼로 글을 써보는중");
		bm.insert(vo);
		log.info("마지막으로 작성된 글 번호"+vo.getPno());
	}
	
	@Test
	public void testUpdate() {
		PostVO vo = new PostVO();
		vo.setTitle("매퍼글수정테스트");
		vo.setContent("매퍼로 글 수정하는중");
		vo.setPno(2L);
		log.info("1개면 제대로 업데이트 된거임 "+bm.update(vo));
	}
	
	@Test
	public void testDeletePost() {
		log.info("1개면 제대로 지운거임 "+bm.deletePost(4L));
	}
}
