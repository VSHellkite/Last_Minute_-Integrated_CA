
package backend.Sevices;

import java.util.List;
import backend.models.User;

    public interface UserService {
    User login(String username, String password);
    User createUser(User newUser);

}