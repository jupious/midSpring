package edu.kwak.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameAPI {
	
	@PostMapping("/laser")
	public List<Integer> laser(){
		List<Integer> list = new ArrayList<Integer>();
		Random r = new Random();
		for(int i = 0; i < 2; i++) {
			int laser1 = r.nextInt(3);				
			while(list.contains(laser1)) {
				laser1 = r.nextInt(3);
			}
			list.add(laser1);
		}
		return list;
	}
	
}
