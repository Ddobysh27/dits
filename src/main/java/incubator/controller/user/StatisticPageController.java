package incubator.controller.user;


import incubator.model.Statistic;
import incubator.model.User;
import incubator.service.StatisticService;
import incubator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StatisticPageController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/goUserHome")
    public String goHome() {
        return "User/user";
    }

    @GetMapping(value = "/personalStatistic")
    public String resultPageFill(ModelMap modelMap) {
        modelMap.addAttribute("statistic", userService.getUserByUsername(getPrincipal()).getStatistics());
        return "User/personalStatistic";
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
