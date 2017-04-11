package com.sparkman.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="Routines")
public class Routine implements Serializable {

    public Routine() {
    }

    @Id
    @Column(name = "routineId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long routineId;
    public Long getRoutineId() {
        return routineId;
    }

    public void setRoutineId(Long routineId) {
        this.routineId = routineId;
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

    @OneToMany(cascade = {CascadeType.ALL})
    private Collection<Set> sets;
    public Collection<Set> getSets() {
        return sets;
    }

    public void setSets(Collection<Set> sets) {
        this.sets = sets;
    }
}