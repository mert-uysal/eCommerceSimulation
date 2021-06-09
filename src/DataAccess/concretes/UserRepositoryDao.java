package DataAccess.concretes;

import DataAccess.abstracts.UserRepository;
import Entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryDao implements UserRepository {
    List<User> allUsers = new ArrayList<>();

    @Override
    public void add(User user) {
        allUsers.add(user);
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public boolean checkLogin(String email, String password) {
        for(User user : getAllUser()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmailUsing(String email) {
        for(User userSearch : getAllUser()) {
            if(userSearch.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return allUsers;
    }
}


