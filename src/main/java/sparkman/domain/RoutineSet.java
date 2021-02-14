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
@Table(name="RoutineSets")
public class RoutineSet implements LiteWeightEntity, Serializable {

    private static final long serialVersionUID = 1L;

    public RoutineSet() {
        // Empty constructor necessary for hibernate, I think
    }

    @Id
    @Column(name = "routineSetId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long routineSetId;
    public Long getId() {
        return routineSetId;
    }

    public void setId(Long routineSetId) {
        this.routineSetId = routineSetId;
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