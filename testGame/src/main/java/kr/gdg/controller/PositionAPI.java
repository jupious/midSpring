package kr.gdg.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionAPI {
	List<Double> recs = new ArrayList<>();
	List<Double> recs2 = new ArrayList<>();
	
	@PostMapping("/getPosition")
	public List<Integer> getPosition() {
		Random r = new Random();
		int a = r.nextInt(20);
		int b = r.nextInt(20);
		List<Integer> list = new ArrayList<Integer>();
		list.add(a);
		list.add(b);
		
		return list;
	}
	
	@PostMapping("/getRecords/{rec}")
	public List<Double> getRecords(@PathVariable("rec") double rec){
		if(rec != -1) {			
			recs.add(rec);
		}
		Collections.sort(recs);
		return recs;
	}
	
	@PostMapping("/timer")
	public int timer() {
		Random r = new Random();
		return r.nextInt(3000)+2000;
	}
	@PostMapping("/getRecords2/{rec}")
	public List<Double> getRecords2(@PathVariable("rec") double rec){
		if(rec != -1) {			
			recs2.add(rec);
		}
		Collections.sort(recs2);
		return recs2;
	}
}
