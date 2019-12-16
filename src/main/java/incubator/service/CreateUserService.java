package incubator.service;

import incubator.dao.UserRepository;
import incubator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleService roleService;

    private static String[] allRoles = {"USER", "TUTOR", "ADMIN"};

    public static String[] getAllRoles() {
        return allRoles;
    }


    @Transactional
    public void сreateUser(User user, String nameRole) {
        user.setRole(roleService.createRole(nameRole));
        userRepository.create(user);
    }

//    @Transactional
//    public boolean ifExistsUserWithLogin(String login) {
//        return userRepository.ifExistsUserWithLogin(login);
//    }

}
