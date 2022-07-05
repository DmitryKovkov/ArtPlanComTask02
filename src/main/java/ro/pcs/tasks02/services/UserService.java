package ro.pcs.tasks02.services;

import ro.pcs.tasks02.models.User;

public interface UserService {
    User create(User user);
    User getUserBylogin (String login);
}
