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
public class MemberUpdate {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpastudy");
		EntityManager manager = factory.createEntityManager(); // 메모리 공간 만듦
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			
			// 수정하려고 하는 정보가 있는지 확인 후에 삭제!
			Member member = manager.find(Member.class, "f01@naver.com"); // 검색 후 없으면 null반환
			
			if(member == null) {
				System.out.println("친구 정보 없음");
			}else {
				member.setUsername("임꺽정"); 
				member.setBirthday(LocalDate.of(1990, 12, 25));
				member.setAge(27);
				System.out.println("이름 변경 완료");
			}
			
			tx.commit(); // 저장
			
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			manager.close();
			factory.close();
		}
		
		
	}

}
