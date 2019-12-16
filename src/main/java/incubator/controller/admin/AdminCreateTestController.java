package incubator.controller.admin;


import incubator.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class AdminCreateTestController {

    @Autowired
    TopicService topicService;

    @Autowired
    TestService testService;

    @Autowired
    QuestionService questionService;

    @Autowired
    RoleService roleService;

    @GetMapping("/createTest")
    public String createTest(Model model){
        model.addAttribute("topics", topicService.getNamesTopics());
        model.addAttribute("tests", testService.getNamesTests() );
        model.addAttribute("questions", questionService.getNamesQuestions());
        return "Admin/createTest";
    }




}
