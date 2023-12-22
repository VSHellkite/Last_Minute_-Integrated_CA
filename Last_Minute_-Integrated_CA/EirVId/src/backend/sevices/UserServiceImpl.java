
package backend.Sevices;

import backend.models.User;
import backend.repository.UserRepositoryImpl;
import backend.repository.UserRepository;


    public class UserServiceImpl implements UserService {

        private UserRepository repository = new UserRepositoryImpl();
    @Override
    public User login(String username, String password) {
        return repository.login(username, password);
    }


    @Override
    public User createUser(User newUser) {
        if (repository.isUserExists(newUser.getUserlogin())) {
            System.out.println("User already exists. Please select different login.");
            return null;
        }
        
        return repository.createUser(newUser);
    }


    }
