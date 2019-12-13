package incubator.service;

import incubator.dao.UserRepository;
import incubator.model.Role;
import incubator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CreateUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleService roleService;

//    private static String[] allRoles = {"User", "Tutor", "Admin"};
//    private static String[] allRoles = {"user", "tutor", "admin"};

//    public static String[] getAllRoles() {
//        return allRoles;
//    }

    private static List<Role> allRolesListObject = new ArrayList<Role>();

    public static List<Role> getAllRolesListObject() {
        Role user = new Role(1,0,0);
        Role tutor = new Role(0,1,0);
        Role admin = new Role(0,0,1);
        allRolesListObject.add(user);
        allRolesListObject.add(tutor);
        allRolesListObject.add(admin);

        return allRolesListObject;
    }


    public void сreateUser(User user) {
//        Role role =  roleService.createRole(user.);
        Role role = user.getRole();
        //user.setNormanRole();
        userRepository.create(user);

    }


}
