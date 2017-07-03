package sparkman.service;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import sparkman.domain.GymSession;
import sparkman.domain.User;
import sparkman.util.HibernateUtil;

import java.util.Date;

@Service
public class WorkoutServiceImpl implements WorkoutService {
    public User getUser(Long userId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        User user = session.get(User.class, userId);
        session.getTransaction().commit();

        HibernateUtil.getSessionFactory().close();

        return user;
    }

    public User saveUser(User user) {
        if (user.getDateCreated() == null) {
            user.setDateCreated(new Date());
        }

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(user);
        session.getTransaction().commit();

        HibernateUtil.getSessionFactory().close();

        return user;
    }

    public GymSession saveWorkout(GymSession gymSession) {
        if (gymSession.getDate() == null) {
            gymSession.setDate(new Date());
        }

        User user = gymSession.getUser();
        if (user.getUsername() == null) {
            user = getUser(user.getId());
            gymSession.setUser(user);
        }

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(gymSession);
        session.getTransaction().commit();

        HibernateUtil.getSessionFactory().close();

        return gymSession;
    }
}
