package com.kdigital.jpa03;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kdigital.jpa03.entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@SpringBootApplication
public class MemberInsert {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpastudy");
		EntityManager manager = factory.createEntityManager(); // 메모리 공간 만듦
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			
			for(int i =0;i<10;i++) {
				Member member = new Member("f"+i+"1@naver.com","이름_"+i, LocalDate.of(1999,01,20),26+i);
				manager.persist(member); // insert 명령어 (메모리에 잠깐 담긴 상태, 저장된 것은 아님)
			} // Member 객체 10개 생성
						
			tx.commit(); // 저장
			
			System.out.println("저장완료");
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			manager.close();
			factory.close();
		}
		
		
	}

}
