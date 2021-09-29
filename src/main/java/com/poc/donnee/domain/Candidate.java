package com.poc.donnee.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "candidate")
public class Candidate {

	@Id
	private String id;

	private String name;

	private double exp;

	@Indexed(unique = true)
	private String email;

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidate(String name, double exp, String email) {
		super();
		this.name = name;
		this.exp = exp;
		this.email = email;
	}

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

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", exp=" + exp + ", email=" + email + "]";
	}
}
