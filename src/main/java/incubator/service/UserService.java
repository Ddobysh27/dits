package incubator.service;

import incubator.dao.UserRepository;
import incubator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<String> getUsernames() {
        List<User> list = userRepository.findAll(User.class, userRepository.getBeanToBeAutowired());
        List<String> usernames = new ArrayList<>();
        for (User u : list
        ) {
            usernames.add(u.getLogin());
        }
        return usernames;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll(User.class, userRepository.getBeanToBeAutowired());
    }

}
