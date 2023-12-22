package backend.repository;

import backend.models.User;



public interface UserRepository {

    User login(String username, String password);
    boolean isUserExists(String userlogin);
    User createUser(User newUser);
}
