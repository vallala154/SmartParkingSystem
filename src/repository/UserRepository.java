package repository;

import model.User;
import java.util.*;

public class UserRepository {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public User findByEmail(String email) {

        for(User u : users){
            if(u.getEmail().equals(email)){
                return u;
            }
        }

        return null;
    }
}