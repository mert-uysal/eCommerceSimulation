package Business.abstracts;

import Entities.concretes.User;

public interface UserService {
    void add(User user);
    void delete(User user);
    void update(User user);
    void login(String email, String password);
}
