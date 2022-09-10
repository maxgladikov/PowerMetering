package com.gladikov.metering.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

	

@Entity
@Data
@Table(name="USERS", schema="PUBLIC")
public class User {
	
	public User() {}
	public User(String name, String password, String roles) {
		super();
		this.name = name;
		this.password = password;
		this.roles = roles;
		active = true;
	}
	
	
	
	public User(String name, String password, String roles, Boolean active) {
		super();
		this.name = name;
		this.password = password;
		this.roles = roles;
		this.active = active;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(unique=true)
	@NotBlank(message="Street is required")
	private  String name;
	@NotBlank(message="Street is required")
	private  String password;
	private  String roles;
	private  Boolean active;
	private  String activeString;

}




	
	
