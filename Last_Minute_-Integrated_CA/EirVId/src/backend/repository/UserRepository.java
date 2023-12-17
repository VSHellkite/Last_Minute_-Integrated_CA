package backend.repository;

import backend.models.User;
import java.util.List;


public interface UserRepository {

    User login(String username, String password);
    boolean isUserExists(String userlogin);
    User createUser(User newUser);
//    User updateProfile(User userProfile);
    public List<User> listUsers();
}
