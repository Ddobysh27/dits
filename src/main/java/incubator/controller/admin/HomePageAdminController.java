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


    @GetMapping(value = "/adminStatistic")
    public String showStatisticPage() {
        return "Admin/adminStatistic";
    }

    @GetMapping(value = "/goHomeAdmin")
    public String goHomeAdmin() {
        return "Admin/admin";
    }

}
