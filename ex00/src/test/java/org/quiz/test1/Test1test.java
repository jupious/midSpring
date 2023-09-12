package org.quiz.test1;

import java.util.Date;
import java.util.Random;

import org.junit.Test;


public class Test1test {
	@Test
	public void today() {
		System.out.println(new Date());
	}
	@Test
	public void randNum() {
		System.out.println(new Random().nextInt(67)+3);
	}
}
