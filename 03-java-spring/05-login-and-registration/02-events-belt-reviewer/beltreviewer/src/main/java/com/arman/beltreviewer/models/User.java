package com.arman.beltreviewer.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="usres")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message="First Name cannot be blank")
	private String f_name;
	@NotBlank(message="Last Name cannot be blank")
	private String l_name;
	@Email(message = "Please make sure email is in valid format")
	private String email;
	@NotBlank(message="Location must not be blank")
	private String location;
	private String state;
	@Size(min=5,message="Password must be atleast 5 characters")
	private String password;
	@Transient
	private String confirm_pw;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "host",cascade = CascadeType.ALL)
	private List<Event> events;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
				name="user_event",
				joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="event_id"))
	private List<Event> joinedEvents;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Message> messages;
	
	@Column(updatable = false)
	private Date created_at;
	private Date updated_at;
	
	
	
	public User() {

	}

	public User(Long id, String f_name, String l_name, String email, String location, String state, String password,
			String confirm_pw, List<Event> events, List<Event> joinedEvents, List<Message> messages, Date created_at,
			Date updated_at) {
		
		this.id = id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.location = location;
		this.state = state;
		this.password = password;
		this.confirm_pw = confirm_pw;
		this.events = events;
		this.joinedEvents = joinedEvents;
		this.messages = messages;
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

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm_pw() {
		return confirm_pw;
	}

	public void setConfirm_pw(String confirm_pw) {
		this.confirm_pw = confirm_pw;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Event> getJoinedEvents() {
		return joinedEvents;
	}

	public void setJoinedEvents(List<Event> joinedEvents) {
		this.joinedEvents = joinedEvents;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
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
