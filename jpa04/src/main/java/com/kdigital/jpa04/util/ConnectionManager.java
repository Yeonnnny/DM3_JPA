package com.kdigital.jpa04.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionManager {
	// 늘 상 일어나는 동작들 외부로 빼는 작업
	private static EntityManagerFactory factory ;
	
	static { // 클래스 생성될 때 바로 메모리에 올라가도록
		factory = Persistence.createEntityManagerFactory("jpastudy"); 
	}
	
	public static EntityManager getManager() {
		return factory.createEntityManager();
	}
	
	public static void close() {
		factory.close();
	}

}
