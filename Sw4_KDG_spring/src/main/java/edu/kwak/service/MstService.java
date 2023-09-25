package edu.kwak.service;

import java.util.List;

import edu.kwak.domain.MstVO;

public interface MstService {
	
	boolean insert(MstVO vo);
	
	MstVO search(String code);
	
	boolean modify(MstVO vo);
	
	boolean delete(String code);
	
	List<MstVO> groupList();
	
	List<MstVO> priority();
	
	List<MstVO> benefit();
	
	List<MstVO> jGroup();
	
	List<MstVO> list();
}
