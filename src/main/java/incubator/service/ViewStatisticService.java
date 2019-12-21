package incubator.service;

import incubator.dao.QuestionRepository;
import incubator.dao.StatisticRepository;
import incubator.dao.TestRepository;
import incubator.model.Question;
import incubator.model.Statistic;
import incubator.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ViewStatisticService {


    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    TestRepository testRepository;

    @Autowired
    TestService testService;

    @Autowired
    StatisticService statisticService;

    @Autowired
    StatisticRepository statisticRepository;

    @Autowired
    QuestionService questionService;


    private ViewStatistic getQuestionInfo(Question question) {
        ViewStatistic viewStatistic;

        //вынестив в отдельный метод
        List<Statistic> statisticList = statisticService.getAllStatisticByQuestionId(question.getQuestionId());// statisticRepository.findAll(Statistic.class, statisticRepository.getBeanToBeAutowired()) ;
        //get list by currently question
        if (!statisticList.isEmpty()) {
            int numberOfTimes = statisticList.size();
            //count all times to answer the question
            int countOfCorrectAnswers = 0;
            //count correct times to answer the question
            for (Statistic statistic : statisticList) {
                if (statistic.isCorrect(statistic.getCorrect())) {
                    countOfCorrectAnswers++;
                }
            }
            viewStatistic = new ViewStatistic(
                    question.getDescription(),
                    numberOfTimes,
                    //вынести в отдельный метод процент правильных ответов
                    (int) Math.round(((double) countOfCorrectAnswers) / numberOfTimes * 100));
        } else {
            viewStatistic = null;
        }
        return viewStatistic;
    }


    public List<ViewStatistic> getQuestionStatisticList() {
        List<ViewStatistic> questionInfoList = new ArrayList<>();
        ViewStatistic viewStatistic;
        List<Question> questionList = questionService.getAllQuestions();  //  .findAll(Question.class, questionRepository.getBeanToBeAutowired());
        for (Question question : questionList) {
            viewStatistic = getQuestionInfo(question);
            if (viewStatistic != null) {
                questionInfoList.add(viewStatistic);
            }
        }
        // сортировка списка по названию вопроса
        questionInfoList.sort(Comparator.comparing(ViewStatistic::getName));
        return questionInfoList;
    }

    private ViewStatistic getTestInfo(Test test) {
        ViewStatistic viewStatistic;
        //вынестив в отдельный метод
        //List<Statistic> statisticList = statisticService.getAllStatisticByQuestionId(question.getQuestionId());// statisticRepository.findAll(Statistic.class, statisticRepository.getBeanToBeAutowired()) ;
        List<Statistic> statisticList = statisticService.getAllStatisticByTestId(test.getTestId());// statisticRepository.findAll(Statistic.class, statisticRepository.getBeanToBeAutowired()) ;
        //get list by currently question
        // questionService.getAllQuestions().removeIf(t -> test.getTestId() != t.getTest().getTestId())

        if (!statisticList.isEmpty()) {
            int numberOfQuestionInTest = test.getQuestions().size();
            int numberOfTimes = Math.round(statisticList.size() / numberOfQuestionInTest);
            //count all times to answer the question
            int countOfCorrectAnswers = 0;
            for (Statistic statistic : statisticList) {
                if (statistic.isCorrect(statistic.getCorrect())) {
                    countOfCorrectAnswers++;
                }
            }
            viewStatistic = new ViewStatistic(
                    test.getName(),
                    numberOfTimes,
                    //вынести в отдельный метод процент правильных ответов
                    (int) Math.round(((double) countOfCorrectAnswers / numberOfQuestionInTest) / numberOfTimes * 100));
        } else {
            viewStatistic = null;
        }
        return viewStatistic;
    }


    public List<ViewStatistic> getTestStatisticList() {
        List<ViewStatistic> testInfoList = new ArrayList<>();
        ViewStatistic viewStatistic;
        List<Test> testList = testService.getAllTests(); ///testRepository.findAll(Test.class, testRepository.getBeanToBeAutowired());
        for (Test test : testList) {
            viewStatistic = getTestInfo(test);
            if (viewStatistic != null) {
                testInfoList.add(viewStatistic);
            }
        }
        // сортировка списка по названию теста
        testInfoList.sort(Comparator.comparing(ViewStatistic::getName));
        return testInfoList;
    }


}
