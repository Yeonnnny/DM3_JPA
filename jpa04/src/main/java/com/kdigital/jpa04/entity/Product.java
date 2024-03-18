package com.kdigital.jpa04.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString

@Entity
public class Product {
	@Id
	@Column(name = "prod_id")
	@SequenceGenerator(
			name = "prod_seq_generator", // 인스턴스 변수와 연동하기 위한 이름
			sequenceName = "prod_seq", // 오라클의 seqeunce 객체 이름 정확히
			initialValue = 1, // 초기값
			allocationSize = 1 // 1로 주지 않고 다른 값을 주는 경우에 중복되는 값이 발생될 가능성이 높아 1로 줘야 함
	)
	@GeneratedValue(generator = "prod_seq_generator")
	private Long prodId; // 오라클의 seqeunce 객체를 가지고 자동발생하고자 함

	@Column(name = "prod_name")
	private String prodName;

	@Enumerated (EnumType.STRING)  
	private Season season;
  
	@Column(name = "unit_price")
	private int unitPrice;
	
	public Product() {}

	public Product(String prodName, Season season, int unitPrice) { // 자동생성되는 prodId는 생성하지 않음
		super();
		this.prodName = prodName;
		this.season = season;
		this.unitPrice = unitPrice;
	}
 
	
	public Long getProdId() {
		return prodId;
	}
	
	  
	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public int getUnitPrice() {
		return unitPrice;
	}   

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	

}
