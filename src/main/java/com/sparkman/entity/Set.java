package com.sparkman.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Sets")
public class Set implements LiteWeightEntity, Serializable {

    public Set() {
    }

    @Id
    @Column(name = "setId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long setId;
    public Long getId() {
        return setId;
    }

    public void setId(Long setId) {
        this.setId = setId;
    }

    @ManyToOne
    @JoinColumn(name = "routineId")
    private Routine routine;
    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    @Column(name = "reps")
    private Integer reps;
    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    @Column(name = "weight")
    private Integer weight;
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Column(name = "comment")
    private String comment;
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}