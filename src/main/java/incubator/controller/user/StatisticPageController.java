package incubator.controller.user;


import incubator.model.Statistic;
import incubator.model.User;
import incubator.service.QuestionStatModel;
import incubator.service.SortByQuestionId;
import incubator.service.StatisticService;
import incubator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class StatisticPageController {

    @Autowired
    UserService userService;

    @Autowired
    StatisticService statisticService;

    @GetMapping(value = "/goUserHome")
    public String goHome() {
        return "User/user";
    }

    @GetMapping(value = "/personalStatistic")
    public String resultPageFill(ModelMap modelMap) {
        List<QuestionStatModel> varList = statisticService.getStatList(userService.getUserByUsername(getPrincipal()).getUserId());
        Collections.sort(varList, new SortByQuestionId());
        modelMap.addAttribute("statistic", varList);
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
