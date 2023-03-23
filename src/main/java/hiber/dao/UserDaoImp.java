package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
   }

   @Override
   public User getOwner(int series, String model) {
      try {
         return sessionFactory.getCurrentSession()
                 .createQuery("FROM User WHERE car.model = :model AND car.series = :series", User.class)
                 .setParameter("model", model)
                 .setParameter("series", series).getSingleResult();
      } catch (NoResultException e) {
         System.err.println("Машина с указанными серией и моделью не найдена");
      }
      return null;
   }



}
