package rc.bootsecurity.service;

import org.springframework.stereotype.Service;
import rc.bootsecurity.model.User;
import rc.bootsecurity.repository.IUserRepository;

@Service
public class UserService implements IUserService {

    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByUserName(name);
    }
}
