package DataAccess.abstracts;

import Entities.concretes.User;

import java.util.List;

public interface UserRepository {
    void add(User user);
    void delete(User user);
    void update(User user);
    boolean checkLogin(String email, String password);
    boolean isEmailUsing(String email);
    List<User> getAllUser();
}
