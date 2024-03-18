package com.kdigital.jpa04.service;

import java.util.Scanner;

import com.kdigital.jpa04.entity.Product;
import com.kdigital.jpa04.entity.Season;
import com.kdigital.jpa04.util.ConnectionManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ProductServiceImpl implements ProductService{
	Scanner scanner = new Scanner(System.in);
	
	
	public ProductServiceImpl() {
		String choice;
		while(true) {
			
			menu();
			choice = scanner.nextLine();
			switch (choice) {
			case "1": insert();break;
			case "2": selectOne();break;
			case "3": update();break;
			case "4": delete();break;
			case "0": 
				System.out.println("프로그램 종료");
				ConnectionManager.close();
				return;
			}
			scanner.nextLine();
		}
		
	}

	//메인 메뉴
	public void menu() {
		System.out.print("1)입력   2)조회   3)수정   4)삭제   0)종료 : ");
	}
			
	@Override
	public void insert() {
		String prodName,s;
		int price;
		System.out.print("상품명 : ");
		prodName = scanner.nextLine();
		
		System.out.print("계절 : ");
		s = scanner.next();
		Season season = Season.valueOf(s); // string타입을 enum타입으로 반환
		
		System.out.print("가격 : ");
		price = scanner.nextInt();
		
		
		Product product = new Product(prodName, season, price); // 저장할 Product 객체
		
		
		EntityManager manager = ConnectionManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			
			manager.persist(product);
			
			tx.commit();
			System.out.println("저장완료");
		} catch (Exception e) {
			tx.rollback();
		}finally {
			manager.close();
		}

		
	}

	@Override
	public boolean update() {
		String prodName, s;
		int price, prodId;	
		
		System.out.print("수정할 제품 번호 : ");
		prodId = scanner.nextInt();
		
		EntityManager manager = ConnectionManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			
			Product product = manager.find(Product.class, prodId);
			
			if(product==null) {
				System.out.println("## 제품이 없습니다.");
				return false;
			}else {
				// 입력받기
				System.out.println("수정할 내용 입력");
				scanner.nextLine();
				System.out.print("상품명 : ");
				prodName = scanner.nextLine();
				System.out.print("계절 : ");
				s = scanner.nextLine();
				Season season = Season.valueOf(s); // 문자열을 enum 타입으로 반환
				System.out.print("가격 : ");
				price = scanner.nextInt();
				
				// 수정
				product.setProdName(prodName);
				product.setSeason(season);
				product.setUnitPrice(price);
			}
			tx.commit();
			System.out.println("수정 완료");
		} catch (Exception e) {
			tx.rollback();
		}finally {
			manager.close();
		}

		return true;
	}

	@Override
	public boolean delete() {
		int prodId;
		
		System.out.print("삭제할 제품 번호 : ");
		prodId = scanner.nextInt();
		
		EntityManager manager = ConnectionManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		
		try {
			tx.begin();
			
			Product product = manager.find(Product.class, prodId);
			if(product == null) {
				System.out.println("## 제품이 없습니다.");
				return false;
			}else {
				manager.remove(product);				
			}
			tx.commit();
			System.out.println("삭제 완료");
			
		}  catch (Exception e) {
			tx.rollback();
		}finally {
			manager.close();
		}
		
		return true;
	}

	@Override
	public Product selectOne() {
		int prodId;
		
		System.out.print("조회할 제품 번호 : ");
		prodId = scanner.nextInt();
		
		EntityManager manager = ConnectionManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			
			Product product = manager.find(Product.class, prodId);
			
			if(product == null) {
				System.out.println("## 제품이 없습니다.");
			}else {
				System.out.println(product);				
			}
			
			//tx.commit(); // insert, update, delete에만 필요함
			
		} catch (Exception e) {
			tx.rollback();
		}finally {
			manager.close();
		}
		
		return null;
	}

}
