package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      userService.add(new User("User5", "Lastname5", "user5@mail.ru", new Car("car1")));
      userService.add(new User("User6", "Lastname6", "user6@mail.ru", new Car("car2")));
      userService.add(new User("User7", "Lastname7", "user7@mail.ru", new Car("car3")));
      userService.add(new User("User8", "Lastname8", "user8@mail.ru", new Car("car4")));
      userService.add(new User("User9", "Lastname9", "user9@mail.ru", new Car("car5")));

      List<User> usersNew = userService.listUsers();
      for (User user : usersNew) {
         System.out.println(user.toString());
      }

      User twinUser = userService.getOwner(1, "car1");
      System.out.println(twinUser.toString());

      context.close();
   }
}
