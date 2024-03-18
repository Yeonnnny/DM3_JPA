package com.kdigital.jpa01.vo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@ Entity // 테이블이 Entity MyUser와 연결 //DB테이블과 매핑하는 대상임을 알려줌
@ Table(name = "myuser")

public class MyUser {
	private String username;
	private String email;
	
	@Column(name="join_date")
	private LocalDateTime joinDate;

	public MyUser() {
		super();
	}
	
	public MyUser(String username, String email, LocalDateTime joinDate) {
		super();
		this.username = username;
		this.email = email;
		this.joinDate = joinDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}


}





