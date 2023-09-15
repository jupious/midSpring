package edu.kwak.persistance;

import static org.junit.Assert.fail;

import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	@Test
	public void testConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydb", "aaa", "1234");
			log.info("접속성공");
		} catch (Exception e) {
			fail("접속 실패"+e.getMessage());
		}
	}
	@Test
	public void aaa() {
		log.info("저장해라");
	}
}
