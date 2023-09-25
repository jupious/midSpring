package edu.kwak.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.kwak.dao.MstDAO;
import edu.kwak.domain.MstVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Service
public class MstServiceImpl implements MstService {

	private MstDAO dao;
	
	@Override
	public boolean insert(MstVO vo) {
		log.info("제품삽입~~~~~~~~~~");
		boolean res;
		try {
			res = dao.inputProduct(vo) == 1 ? true : false;
		} catch (Exception e) {
			res = false;
		}
		return res;
	}

	@Override
	public MstVO search(String code) {
		log.info("제품검색~~~~~~~~~~");
		return dao.searchProduct(code);
	}

	@Override
	public boolean modify(MstVO vo) {
		log.info("제품수정~~~~~~~~~~");
		boolean res;
		try {
			res = dao.modifyProduct(vo) == 1 ? true : false;
		} catch (Exception e) {
			res = false;
		}
		return res;
	}

	@Override
	public boolean delete(String code) {
		log.info("제품삭제~~~~~~~~~~");
		boolean res;
		try {
			res = dao.deleteProduct(code) == 1 ? true : false;
		} catch (Exception e) {
			res = false;
		}
		return res;
	}

	@Override
	public List<MstVO> groupList() {
		log.info("그룹 목록~~~~~~~~~~");
		return dao.groupName();
	}

	@Override
	public List<MstVO> priority() {
		log.info("우선생산제품~~~~~~~~~~");
		return dao.priorityProduct();
	}

	@Override
	public List<MstVO> benefit() {
		log.info("이익순위~~~~~~~~~~");
		return dao.benefitRank();
	}

	@Override
	public List<MstVO> jGroup() {
		log.info("그룹별 재고수량~~~~~~~~~~");
		return dao.jnumGroup();
	}

	@Override
	public List<MstVO> list() {
		log.info("전체 제품목록~~~~~~~~~~~~~~~");
		return dao.list();
	}

}
