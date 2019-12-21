package incubator.controller.admin;

import incubator.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class AdminStatisticPageController {

    @Autowired
    ViewStatisticService viewStatisticService;


    @GetMapping("/statisticByQuestion")
    public String viewStatisticQuestion(ModelMap modelMap) {
        List<ViewStatistic> statisticByQuestionList = viewStatisticService.getQuestionStatisticList();
//            Collections.sort(varList, new SortByQuestionId());
        modelMap.addAttribute("statisticList", statisticByQuestionList);
        return "Admin/statisticByQuestion";
    }

    @GetMapping("/statisticByTest")
    public String viewStatisticTest(ModelMap modelMap) {
        List<ViewStatistic> statisticByTestList = viewStatisticService.getTestStatisticList();
//            Collections.sort(varList, new SortByQuestionId());
        modelMap.addAttribute("statisticList", statisticByTestList);
        return "Admin/statisticByTest";
    }


}
