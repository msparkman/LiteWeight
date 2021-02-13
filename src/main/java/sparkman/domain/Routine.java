package sparkman.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Routines")
public class Routine implements LiteWeightEntity, Serializable {

    public Routine() {}

    @Id
    @Column(name = "routineId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long routineId;
    public Long getId() {
        return routineId;
    }

    public void setId(Long routineId) {
        this.routineId = routineId;
    }

	@ManyToOne
	@JoinColumn(name = "gymSessionId")
	private GymSession gymSession;
	public GymSession getGymSession() {
		return gymSession;
	}

	public void setGymSession(GymSession gymSession) {
		this.gymSession = gymSession;
	}

    @Column(name = "name")
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "restMinutes")
    private Double restMinutes;
    public Double getRestMinutes() {
        return restMinutes;
    }

    public void setRestMinutes(Double restMinutes) {
        this.restMinutes = restMinutes;
    }
}