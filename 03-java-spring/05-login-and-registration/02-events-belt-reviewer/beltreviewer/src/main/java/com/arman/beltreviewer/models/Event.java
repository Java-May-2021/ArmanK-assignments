package com.arman.beltreviewer.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message="Event name cannot be empty")
	private String name;
	@Future(message="Date must be in the future")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	@NotBlank(message="Location cannot be empty")
	private String location;
	@NotBlank(message="Please choose a state")
	private String state;
	@ManyToOne(fetch = FetchType.LAZY)
	private User host;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "user_event",
			joinColumns = @JoinColumn(name="event_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			)
	private List<User> participators;
	
	@Column(updatable = false)
	private Date created_at;
	private Date updated_at;
	
	
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Event() {
	
	}

	public Event(Long id, String name, Date date, String location, User host, List<User> participators, Date created_at,
			Date updated_at) {
	
		this.id = id;
		this.name = name;
		this.date = date;
		this.location = location;
		this.host = host;
		this.participators = participators;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	@PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<User> getParticipators() {
		return participators;
	}

	public void setParticipators(List<User> participators) {
		this.participators = participators;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
}
