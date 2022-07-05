package ro.pcs.tasks02.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pcs.tasks02.exceptions.AnimalNotFoundException;
import ro.pcs.tasks02.models.User;
import ro.pcs.tasks02.repositories.UserRepository;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserBylogin(String login) {
        return userRepository.findByLogin(login);
    }
}
