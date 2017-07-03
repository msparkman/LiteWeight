package sparkman;

import com.google.common.collect.Lists;
import sparkman.domain.GymSession;
import sparkman.domain.LiteWeightEntity;
import sparkman.domain.Routine;
import sparkman.domain.Set;
import sparkman.domain.User;
import sparkman.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Collection;
import java.util.Date;

public class LiteWeightTest {
    public static void main( String[] args ) {
        System.out.println( "Going to save workout information!" );

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Collection<LiteWeightEntity> entities = Lists.newArrayList();

        // Grab the user if it already exists
        User user = session.get(User.class, 1L);
        if (user == null) {
            user = new User();
            user.setUsername("testUser");
            user.setPassword("testPassword");
            user.setDateCreated(new Date());
            entities.add(user);
        }

		GymSession gymSession = new GymSession();
        gymSession.setDate(new Date());
        gymSession.setType("chest");
        gymSession.setUser(user);
        entities.add(gymSession);

        Routine routine = new Routine();
        routine.setGymSession(gymSession);
        routine.setName("testWorkout1");
        routine.setRestMinutes(1.5);
        entities.add(routine);

        Set set1 = new Set();
        set1.setRoutine(routine);
        set1.setWeight(155);
        set1.setReps(5);
        entities.add(set1);

        Set set2 = new Set();
        set2.setRoutine(routine);
        set2.setWeight(155);
        set2.setReps(5);
        set2.setComment("struggled on last");
        entities.add(set2);

        Set set3 = new Set();
        set3.setRoutine(routine);
        set3.setWeight(155);
        set3.setReps(4);
        set3.setComment("needed spotter");
        entities.add(set3);
        
        for (LiteWeightEntity entity : entities) {
            session.save(entity);
        }

        session.getTransaction().commit();

        HibernateUtil.getSessionFactory().close();

        System.out.println("Everything is done.");
    }
}
