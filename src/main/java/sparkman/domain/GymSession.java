package sparkman.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GymSessions")
public class GymSession implements LiteWeightEntity, Serializable {

	private static final long serialVersionUID = 1L;

	public GymSession() {
		// Empty constructor necessary for hibernate, I think
	}

	@Id
	@Column(name = "gymSessionId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long gymSessionId;
	public Long getId() {
		return gymSessionId;
	}

	public void setId(Long gymSessionId) {
		this.gymSessionId = gymSessionId;
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
