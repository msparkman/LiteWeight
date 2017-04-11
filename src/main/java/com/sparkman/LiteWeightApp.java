package com.sparkman;

import com.google.common.collect.Lists;
import com.sparkman.entity.Routine;
import com.sparkman.entity.Set;
import com.sparkman.entity.User;
import com.sparkman.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class LiteWeightApp {
    public static void main( String[] args ) {
        System.out.println( "Going to save a user!" );

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");
        user.setDateCreated(new Date());

        Routine routine = new Routine();
        routine.setDate(new Date());
        routine.setName("testWorkout1");
        routine.setRestMinutes(1.5);
        routine.setType("chest");
        routine.setUser(user);

        Set set1 = new Set();
        set1.setRoutine(routine);
        set1.setWeight(155);
        set1.setReps(5);

        Set set2 = new Set();
        set2.setRoutine(routine);
        set2.setWeight(155);
        set2.setReps(5);
        set2.setComment("struggled on last");

        Set set3 = new Set();
        set3.setRoutine(routine);
        set3.setWeight(155);
        set3.setReps(4);
        set3.setComment("needed spotter");
        routine.setSets(Lists.newArrayList(set1, set2, set3));
        user.setRoutines(Lists.newArrayList(routine));

        session.save(user);
        session.getTransaction().commit();

        HibernateUtil.getSessionFactory().close();

        System.out.println("Everything is done.");
    }
}
