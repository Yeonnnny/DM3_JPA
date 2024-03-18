package com.kdigital.jpa02.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor  // 기본 생성자 만들어줌
@AllArgsConstructor // 생성자 
@Setter
@Getter
@ToString
@Entity //DB 테이블과 매핑하는 대상임을 알려줌
@Table(name = "myuser") // class이름과 table명이 다르면 무조건 써줘야 함


public class User {
	@Id  // primary key 나타내줌
	private String email;
	private String username;
	
	@Column (name="join_date") // 생성한 테이블의 컬럼명과 다르게 사용하는 경우
	private LocalDateTime joinDate;
	
	
}




















