package service;

import model.User;
import repository.UserRepository;
import util.HashUtil;

public class AuthService {

    private UserRepository repo;

    public AuthService(UserRepository repo){
        this.repo = repo;
    }

    public boolean register(String email,String password){

        if(repo.findByEmail(email)!=null){
            return false;
        }

        String hash = HashUtil.hashPassword(password);

        repo.addUser(new User(email,hash));

        return true;
    }

    public User login(String email,String password){

        User user = repo.findByEmail(email);

        if(user==null){
            return null;
        }

        String hash = HashUtil.hashPassword(password);

        if(hash.equals(user.getPasswordHash())){
            return user;
        }

        return null;
    }
}