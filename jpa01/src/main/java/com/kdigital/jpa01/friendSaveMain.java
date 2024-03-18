package com.kdigital.jpa01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class friendSaveMain {

	public static void main(String[] args) {
		// 1) persistence.xml의 name값을 읽어 EntityManagerFactory 객체 생성
		//    DB 연동을 위한 설정값을 읽어오는 작업
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpastudy");// 연동을 위한 코드//unit값 jpastudy라고 주었는데 그 모든 정보를 일어서 저장 
	
		// 2) EntityManagerFactory 객체를 통해 DB연동 처리
		//    설정값 가지고 온 애들 가지고 연동함
		EntityManager entityManager = emf.createEntityManager();
		
		// 3) EntityManagerFactory 객체를 통해 EntityTransactions 객체 생성
		//    쿼리 날리기, 실제 쿼리가 들어가지 않기 때문에 값을 직접 넣어주면 안됨
		EntityTransaction tx = entityManager.getTransaction();
		
		
		// ============================[여기까지가 준비작업]===============================
		// DDL은 Oracle에서 만듦
		
		
	}

}
