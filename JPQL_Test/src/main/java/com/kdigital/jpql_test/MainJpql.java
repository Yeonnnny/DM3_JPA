package com.kdigital.jpql_test;

import java.util.Iterator;
import java.util.List;

import com.kdigital.jpql_test.entity.Member;
import com.kdigital.jpql_test.util.ConnectionManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class MainJpql {
// Java Persistent Query Language
// 모양은 sql 쿼리문과 유사함 but java 코드이기 때문에 대소문자 구분 잘 해야 함
	
	public static void main(String[] args) {
		
		// Member를 여러명 저장
//		for(int i =0 ;i<50;i++) {
//			insertMember(i);
//		} // 저장 완료되었기 때문에 주석 처리
//		
//		// userId가 15번인 회원 1명 조회
//		findById(15L); // select * from test_user where userid = 15;
//		
//		// 회원 삭제
//		deleteMember(50L);
//		deleteMember(2L);
//		deleteMember(3L);
//		deleteMember(7L);
//		
//		// 5번 회원 수정
//		Member member = new Member("Choi", "pwd_choi","choi@naver.com");
//		member.setUserid(1L);
//		updateMember(member);
		
//		// JPQL : 전체 테이블 조회
//		selectAllMember();
//		
		
		// JPQL : 1명만 조회
//		findById();
		int srow=1, pagePerCount=10;
		
		selectAllMember(srow, pagePerCount);
		
		
		// factory close
		ConnectionManager.close();
	}






	/**
	 * 회원을 저장하는 메소드
	 * @param i
	 */
	private static void insertMember(int i) {
		EntityManager manager= ConnectionManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			
			Member member = new Member("name_"+i, "pwd_"+i, "email_"+i+"@naver.com");
			manager.persist(member);
			
			tx.commit();
			System.out.println("저장 완료");
			
		} catch (Exception e) {
			tx.rollback();
		} finally {
			manager.close();
		}
		
	}
	
	/**
	 * 회원 1명 조회
	 * @param i
	 */
	private static void findById(Long id) {
		
		EntityManager manager= ConnectionManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			Member mem = manager.find(Member.class, id);
			if(mem==null) {
				System.out.println("## 멤버 존재하지 않음");
			}else
				System.out.println(mem);

		} catch (Exception e) {
			tx.rollback();
		}finally {
			manager.close();
		}
	}
	
	/**
	 * JPQL로 한 명 검색
	 */
	private static void findById() {
		System.out.println("-------selet one by jpql");

		EntityManager manager= ConnectionManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		Long uid = 13L; //조회하고자하는 번호
		
		try {
			tx.begin();

//			String query = "select * from test_user where user_id=13L";
			String query = "select m from Member m where m.userid=:uid";
			
//			TypedQuery<Member> member = manager.createQuery(query, Member.class);
//			member.setParameter("uid", uid);
//			Member result = member.getSingleResult();
			
			Member result = manager.createQuery(query,Member.class).setParameter("uid", uid).getSingleResult();
						
			System.out.println(result);
			
			
		} catch (Exception e) {
			tx.rollback();
		}finally {
			manager.close();
		}
		
	}

	/**
	 * 회원 1명 삭제
	 * @param l
	 */
	private static void deleteMember(long id) {
		
		
		EntityManager manager= ConnectionManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			Member mem = manager.find(Member.class, id);
			if(mem==null) {
				System.out.println("## 멤버 존재하지 않음");
			}else
				manager.remove(mem);
			
			tx.commit();
			System.out.println("삭제 완료");
		} catch (Exception e) {
			tx.rollback();
		}finally {
			manager.close();
		}
	}
	
	/**
	 * 회원 수정
	 * @param member
	 */
	private static void updateMember(Member member) {
		EntityManager manager= ConnectionManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			Member mem = manager.find(Member.class, member.getUserid());
			
			if(mem==null) {
				System.out.println("## 멤버 존재하지 않음");
			}else {
				mem.setUsername(member.getUsername());
				mem.setPwd(member.getPwd());
				mem.setEmail(member.getEmail());
			}

			tx.commit();
			System.out.println("수정 완료");
		} catch (Exception e) {
			tx.rollback();
		}finally {
			manager.close();
		}
		
	}
	
	/**
	 * 전체 회원 멤버 조회 (JPQL 사용)
	 */
	private static void selectAllMember() {
		System.out.println("-------------select All Member");
		EntityManager manager= ConnectionManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			
			String query = "select m from Member m"; // table명이 아니라 Entity 클래스 이름 써야 함, 별칭 꼭 써야함
			
			TypedQuery<Member> tq = manager.createQuery(query, Member.class);
			List<Member> members = tq.getResultList();
			
			// Iterator로 변환
			Iterator<Member> iter = members.iterator();
			while(iter.hasNext()) {
				System.out.println(iter.next());
			}
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			manager.close();
		}
		
	}
	/**
	 * 페이징 조회 함수
	 * @param srow : 시작 번호
	 * @param pagePerCount : 한 화면에 보여질 개수
	 */
	private static void selectAllMember(int srow, int pagePerCount) {
		System.out.println("-------------select All Member using Paging");
		
		EntityManager manager= ConnectionManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			
			String query = "select m from Member m"; // table명이 아니라 Entity 클래스 이름 써야 함, 별칭 꼭 써야함
			
			TypedQuery<Member> tq = manager.createQuery(query, Member.class);
			
			tq.setFirstResult(srow);
			tq.setMaxResults(pagePerCount); // 페이지에 출력할 개수
			
			List<Member> members = tq.getResultList();
			
			// Iterator로 변환
			Iterator<Member> iter = members.iterator();
			while(iter.hasNext()) {
				System.out.println(iter.next());
			}
			
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
		}finally {
			manager.close();
		}
		
	}

}
