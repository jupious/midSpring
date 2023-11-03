package edu.kwak.controller;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/rank")
	public ResponseEntity<String> rank(@RequestBody HashMap<String, String> data) {
		System.out.println("id = "+data.get("id")+"score = "+data.get("score"));
		ResponseEntity<String> res = null;
		try {
            // 대상 URL 설정
            URL url = new URL("http://m-it.iptime.org:5180/rank");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // HTTP POST 메서드 설정
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // JSON 데이터 설정
            String jsonInputString = "{\"id\": \""+data.get("id")+ "\", \"score\": "+data.get("score")+"}";

            // JSON 데이터 전송
            try (OutputStream os = connection.getOutputStream();
                 OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8")) {
                osw.write(jsonInputString);
                osw.flush();
            }
            
            // 응답 코드 확인
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
            	 connection.disconnect();
            	res = new ResponseEntity<String>("데이터 전송 성공!",HttpStatus.OK);
            } else {
                System.out.println("HTTP POST 요청 실패: " + responseCode);
                connection.disconnect();
                res =  new ResponseEntity<String>("error",HttpStatus.I_AM_A_TEAPOT);
            }

           
        } catch (Exception e) {
            e.printStackTrace();
        }
		return res;
	}
	
}
