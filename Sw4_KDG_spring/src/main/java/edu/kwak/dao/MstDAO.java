package edu.kwak.dao;

import java.util.List;

import edu.kwak.domain.MstVO;

public interface MstDAO {
	
	//제품 삽입
	int inputProduct(MstVO vo);
	
	//제품 검색
	MstVO searchProduct(String code);
	
	//제품수정
	int modifyProduct(MstVO vo);
	
	//제품 삭제
	int deleteProduct(String code);
	
	//그룹이름 리스트
	List<MstVO> groupName();
	
	//우선생산제품
	List<MstVO> priorityProduct();
	
	//이익순위
	List<MstVO> benefitRank();
	
	//그룹별 재고수량
	List<MstVO> jnumGroup();
	
	//전체 제품목록
	List<MstVO> list();
}
