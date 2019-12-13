package incubator.controller.admin;

import incubator.model.Role;
import incubator.model.User;
import incubator.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomePageAdminController {

    @Autowired
    private CreateUserService createUserService;


    @PostMapping("/createUser")
    public String addUser(Model model, User user, Role role) {

        createUserService.сreateUser(user);
        user = new User();

        model.addAttribute("user", user);
        model.addAttribute("allRoles", CreateUserService.getAllRolesListObject());
        model.addAttribute("success","Пользователь добавлен");
        return "Admin/createUser";
    }

    @GetMapping(value = "/createUser")
    public String createUser(Model model) {
        User user = new User();
        Role role = new Role();//+++

        model.addAttribute("user", user);
        model.addAttribute("role", role);//+++
        model.addAttribute("allRoles", CreateUserService.getAllRolesListObject());
        return "Admin/createUser";
    }

    @GetMapping(value = "/createTest")
    public String createTest() {
        return "Admin/createTest";
    }

    @GetMapping(value = "/adminStatistic")
    public String showStatisticPage() {
        return "Admin/adminStatistic";
    }

    @GetMapping(value = "/goHomeAdmin")
    public String goHomeAdmin() {
        return "Admin/admin";
    }

}

//    @GetMapping(value = "/admin")
//    public String adminPage(ModelMap model) {
//        model.addAttribute("user", getPrincipal());
//        return "Admin/admin";
//    }
