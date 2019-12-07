package incubator.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageAdminController {
    @GetMapping(value = "/createTest")
    public String createTest() {
        return "Admin/createTest";
    }

    @GetMapping(value = "/createUser")
    public String createUser() {
        return "Admin/createUser";
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
