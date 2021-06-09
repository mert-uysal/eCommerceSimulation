import Business.abstracts.UserService;
import Business.concretes.UserManager;
import Business.concretes.VerificationManager;
import Core.GoogleAuthAdapter;
import DataAccess.concretes.UserRepositoryDao;
import Entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserManager(new VerificationManager(), new UserRepositoryDao(), new GoogleAuthAdapter());

        User user = new User(1, "ahmet", "uysal", "@hmet@gmail.o", "123456");
        User user1 = new User(1, "me", "u", "mrt@gmail.com", "123456");
        User user2 = new User(3, "mehmet", "uysal", "mehmet@gmail.com", "123");
        User user3 = new User(4, "cevdet", "uysal", "cevdet@cevdet.com", "123456");
        User user4 = new User(1, "mert", "uysal", "mrt@gmail.com", "123456");
        User user5 = new User(2, "ahmet", "uysal", "mrt@gmail.com", "123456");
        User user6 = new User(2, "ahmet", "uysal", "", "123456");

        System.out.println("Register");
        userService.add(user);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        userService.add(user5);
        userService.add(user6);

        System.out.println("Login");
        userService.login("mrt@gmail.com","123456");
        userService.login("test","tset");
        userService.login("test","");

    }
}
