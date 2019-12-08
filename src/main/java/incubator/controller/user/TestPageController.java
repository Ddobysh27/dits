package incubator.controller.user;


import incubator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestPageController {

    @Autowired
    UserService userService;

    private static int counter = 0;

    @GetMapping(value = "/nextTestPage1")
    public String nextTestPage1(ModelMap modelMap) {
        if (counter < 3) {
            counter++;
            return "User/testPage";
        } else
            return resultPageFill(modelMap);
    }

    @GetMapping(value = "/resultPage")
    public String resultPageFill(ModelMap modelMap) {
        modelMap.addAttribute("statistic", userService.getUserByUsername(getPrincipal()).getStatistics());
        return "User/resultPage";
    }

    private static String getPrincipal() {
        String userName = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
