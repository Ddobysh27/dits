package incubator.controller.user;


import incubator.model.Question;
import incubator.model.Statistic;
import incubator.model.Test;
import incubator.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TestPageController {

    @Autowired
    UserService userService;

    @Autowired
    TestService testService;

    @Autowired
    QuestionService questionService;

    @Autowired
    StatisticService statisticService;

    @Autowired
    AnswerService answerService;

    private static Test test;
    private static List<Question> questionList;
    private static int max;
    private static int counter;
    private static String startTest;
    private static String endTest;

    @GetMapping(value = "/goTest")
    public String goTest(@RequestParam String testName, ModelMap modelMap) {
        test = testService.getTestByName(testName);
        questionList = testService.getQuestionsByTest(testName);
        max = questionList.size();
        counter = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        startTest = formatter.format(new Date());

        modelMap.addAttribute("question", questionList.get(counter).getDescription());
        modelMap.addAttribute("answers", questionService.getAnswersByQuestion(questionList.get(counter).getQuestionId()));
        counter++;
        return "User/testPage";
    }

    @GetMapping(value = "/nextTestPage")
    public String nextTestPage1(@RequestParam(value = "choosenAns") String choosenAnswer, ModelMap modelMap) {
        if (counter < max) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            Statistic statistic = new Statistic();

            statistic.setCorrect(answerService.getAnswerByDescription(choosenAnswer).ifCorrect());
            statistic.setDate(formatter.format(new Date()));
            statistic.setQuestion(questionList.get(counter - 1));
            statistic.setUser(userService.getUserByUsername(getPrincipal()));
            statisticService.testingCreateMethod(statistic);

            modelMap.addAttribute("question", questionList.get(counter).getDescription());
            modelMap.addAttribute("answers", questionService.getAnswersByQuestion(questionList.get(counter).getQuestionId()));
            counter++;
            return "User/testPage";
        } else
            return resultPageFill(choosenAnswer, modelMap);
    }

    @GetMapping(value = "/resultPage")
    public String resultPageFill(String choosenAnswer, ModelMap modelMap) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Statistic statistic = new Statistic();

        statistic.setCorrect(answerService.getAnswerByDescription(choosenAnswer).ifCorrect());
        statistic.setDate(formatter.format(new Date()));
        statistic.setQuestion(questionList.get(counter - 1));
        statistic.setUser(userService.getUserByUsername(getPrincipal()));
        statisticService.testingCreateMethod(statistic);

        endTest = formatter.format(new Date());

        modelMap.addAttribute("statistic", statisticService.selectUserTestStatistic(
                "" + userService.getUserByUsername(getPrincipal()).getUserId(),
                "" + startTest,
                "" + endTest
        ));
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
