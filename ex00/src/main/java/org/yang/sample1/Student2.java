package org.yang.sample1;

import org.springframework.stereotype.Component;
import org.yang.sample.StudentInter;

@Component
public class Student2 implements StudentInter {

	@Override
	public void study() {
		System.out.println("공부하는척 하는중");

	}

	@Override
	public void eat() {
		System.out.println("방금 밥먹어서 배부름");

	}

}
