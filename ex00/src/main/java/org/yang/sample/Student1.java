package org.yang.sample;

import org.springframework.stereotype.Component;

@Component
public class Student1 implements StudentInter {

	
	@Override
	public void study() {
		System.out.println("공부중");

	}

	@Override
	public void eat() {
		System.out.println("밥먹는중");

	}

}
