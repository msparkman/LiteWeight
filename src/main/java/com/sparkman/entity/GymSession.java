package com.sparkman.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Sessions")
public class GymSession implements LiteWeightEntity, Serializable {

	public GymSession() {}

	@Id
	@Column(name = "setId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long setId;

	public Long getId() {
		return setId;
	}

	public void setId(Long id) {
		this.setId = setId;
	}

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "date")
	private Date date;
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "type")
	private String type;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
