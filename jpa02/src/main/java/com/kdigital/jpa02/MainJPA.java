package com.kdigital.jpa02;

import java.time.LocalDateTime;

import com.kdigital.jpa02.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainJPA {

	public static void main(String[] args) {
		
		// 1) EntityManagerFactory 생성
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpastudy");
		
		// 2) factory로부터 manager 얻어옴
		EntityManager manager = factory.createEntityManager();
		
		// 3) manager로부터 transaction 얻어옴
		EntityTransaction tx = manager.getTransaction();
		
		// 이제부터 transaction 가능
		
		try {
			tx.begin(); // 트랜잭션 시작
			
			User user = new User("bbbb@bbb.com","홍길동",LocalDateTime.now()); // User객체 생성
			manager.persist(user); // insert 명령어	
		
			tx.commit(); // 저장
			System.out.println("저장완료"); // web 에서는 sysout 쓰면 안됨
			
		} catch (Exception e) {
			tx.rollback(); //Exception 발생시 rollback
		}finally {
			manager.close();
		}
		
		// 리소스 정리 (finally에 써도 됨)
		factory.close();
		
	}

}
