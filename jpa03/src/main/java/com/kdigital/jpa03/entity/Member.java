package com.kdigital.jpa03.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="mem")


public class Member {	
	@Id
	private String email;
	private String username;
	private LocalDate birthday;
	private int age;
	
	public Member() {
		super();
	};
	
	public Member(String email, String username, LocalDate birthday, int age) {
		super();
		this.email = email;
		this.username = username;
		this.birthday = birthday;
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Member [email=" + email + ", username=" + username + ", birthday=" + birthday + ", age=" + age + "]";
	}
	
		
}
