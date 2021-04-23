package com.te.springboot.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_info")
@JsonRootName("employee-info")
@JsonPropertyOrder({ "id", "name" })

public class EmployeeBean implements Serializable {

	


	@Override
	public String toString() {
		return "EmployeeBean [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", password=" + password
				+ "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Id
	@Column
	@JsonProperty("emp_id")
	private Integer id;

	@Column
	private String name;

	@Column(name = "dob")
	private Date birthDate;

	
	@Column
	private String password;

}
