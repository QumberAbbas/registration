package rc.bootsecurity.service;

import rc.bootsecurity.model.User;

public interface IUserService {
    User findUserByName(String name);
}
