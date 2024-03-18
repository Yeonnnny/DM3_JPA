package com.kdigital.jpql_test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter  
@ToString

@Entity
@Table(name="test_user")

public class Member {
	@SequenceGenerator(
			name="user_seq_gen",
			sequenceName = "testuser_seq",
			initialValue = 1,
			allocationSize = 1)
	@Id
	@Column(name="userid") // 같을 때도 써줘도 됨
	@GeneratedValue(generator = "user_seq_gen")
	private Long userid;
	
	@Column(name="username",nullable = false)  //nullable 기본값은 true임
	private String username;
	
	@Column(name="pwd",nullable = false) 
	private String pwd;
	
	@Column(name="email",nullable = false) 
	private String email;

	// 시퀀스로 값이 증가하는 userid는 전달받지 않음
	public Member(String username, String pwd, String email) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.email = email;
	}

	
}