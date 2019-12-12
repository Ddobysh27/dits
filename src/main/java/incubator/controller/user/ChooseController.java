package incubator.controller.user;


import incubator.model.Test;
import incubator.service.StatisticService;
import incubator.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChooseController {

    @Autowired
    TopicService topicService;

    @Autowired
    StatisticService statisticService;

    @GetMapping(value = "/goTest")
    public String goTest() {
        return "User/testPage";
    }

    @RequestMapping(value = "/UserChoose", method = RequestMethod.GET)
    @ResponseBody
    public List<String> l(@RequestParam(value = "topic", required = false) String topic) {
        System.out.println("Hello from controller");
        return topicService.getTestsByTopic(topic);
    }

}