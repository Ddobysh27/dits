package incubator.controller.user;


import incubator.controller.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChooseController {

    @GetMapping(value = "/goTest")
    public String goTest() {
        return "User/testPage";
    }


}
