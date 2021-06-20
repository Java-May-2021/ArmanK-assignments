package com.example.license.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="licenses")
public class License {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="person_id")
	private Person person;
	public License() {
		super();
	}
	private String state;
	private Date expiration_date;
	public License(Person person, String state, Date expiration_date) {
		super();
		this.person = person;
		this.state = state;
		this.expiration_date = expiration_date;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}
}
