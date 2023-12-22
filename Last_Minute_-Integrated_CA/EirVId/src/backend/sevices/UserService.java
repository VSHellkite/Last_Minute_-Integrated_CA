
package backend.Sevices;

import backend.models.User;

    public interface UserService {
    User login(String username, String password);
    User createUser(User newUser);

}