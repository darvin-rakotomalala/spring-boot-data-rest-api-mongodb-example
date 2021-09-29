package com.poc.donnee.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CandidateDTO {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String id;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private double exp;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getExp() {
		return exp;
	}

	public void setExp(double exp) {
		this.exp = exp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
