package incubator.controller.user;


import incubator.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChooseController {

    @Autowired
    TopicService topicService;

    @RequestMapping(value = "/UserChoose", method = RequestMethod.GET)
    @ResponseBody
    public List<String> l(@RequestParam(value = "topic", required = false) String topic) {
        return topicService.getTestsByTopic(topic);
    }

}