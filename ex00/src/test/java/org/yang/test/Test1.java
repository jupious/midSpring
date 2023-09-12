package org.yang.test;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class Test1 {
	//junit으로 테스트하기위해서는 메소드가 public이어야한다.
	@Test
	public void allSum() {
		int sum = 0;
		for(int i = 1; i <= 10 ; i++) {
			sum += i;
			log.debug(sum);
		}
		log.info(sum);
	}
	@Test
	public void div() {
		int i = 10;
		int j = i/10;
		log.info(j);
	}
}
