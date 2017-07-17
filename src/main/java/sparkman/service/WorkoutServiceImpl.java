package sparkman.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sparkman.domain.GymSession;
import sparkman.domain.User;
import sparkman.domain.repository.GymSessionRepository;
import sparkman.domain.repository.UserRepository;
import sparkman.util.HibernateUtil;

import java.util.Date;

@Service
public class WorkoutServiceImpl implements WorkoutService {
	@Autowired private UserRepository userRepository;
	@Autowired private GymSessionRepository gymSessionRepository;

    public User getUser(Long userId) {
        /*Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        User user = session.get(User.class, userId);
        session.getTransaction().commit();

        HibernateUtil.getSessionFactory().close();

        return user;*/
        return userRepository.findOne(userId);
    }

    public User saveUser(User user) {
        if (user.getDateCreated() == null) {
            user.setDateCreated(new Date());
        }

        /*Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(user);
        session.getTransaction().commit();

        HibernateUtil.getSessionFactory().close();

        return user;*/
        return userRepository.save(user);
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

        return gymSessionRepository.save(gymSession);

        /*Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(gymSession);
        session.getTransaction().commit();

        HibernateUtil.getSessionFactory().close();

        return gymSession;*/
    }
}
