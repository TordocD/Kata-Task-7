package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.annotations.NamedQuery;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   User get(int series, String model);
}
