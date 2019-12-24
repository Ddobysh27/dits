package incubator.service;

import incubator.dao.QuestionRepository;
import incubator.model.Question;
import incubator.model.Statistic;
import incubator.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ViewStatisticService {


    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    TestService testService;

    @Autowired
    StatisticService statisticService;

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;


    private ViewStatistic getQuestionInfo(Question question) {
        ViewStatistic viewStatistic;

        //вынестив в отдельный метод
        List<Statistic> statisticList = statisticService.getFilteredStatisticByQuestionId(question.getQuestionId());// statisticRepository.findAll(Statistic.class, statisticRepository.getBeanToBeAutowired()) ;
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
        List<Statistic> statisticList = statisticService.getFilteredStatisticByTestId(test.getTestId());// statisticRepository.findAll(Statistic.class, statisticRepository.getBeanToBeAutowired()) ;
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
                    (int) Math.round(((double) (countOfCorrectAnswers / numberOfQuestionInTest)) / numberOfTimes * 100));
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

    private ViewStatistic getUserTestInfo(Statistic statistic) {

        ViewStatistic viewStatistic;

        List<Statistic> statisticList = statisticService.getFilteredStatisticByTestUser(statistic);

        if (!statisticList.isEmpty()) {
            //int countQuestionInTest = statistic.getQuestion().getTest().getQuestions().size();
            //int numberOfTimes = Math.round(statisticList.size() / numberOfQuestionInTest);
            int countAllAnswers = statisticList.size(); //countAllAnswer(statistic);
            int countOfCorrectAnswers = countCorrectAnswer(statistic);

            //посчитать сколько раз проходил данный тест данный пользователь
            int countTimesCompletedTest = countUserCompletedTest(statistic);


            viewStatistic = new ViewStatistic(
                    statistic.getUser().getFIO(),
                    statistic.getQuestion().getTest().getName(),
                    countTimesCompletedTest,
                    //вынести в отдельный метод процент правильных ответов
                    calculatePercentage(statisticList)
                    //(int) Math.round(((double) (countOfCorrectAnswers / countAllAnswers)) * 100)
            );

        } else {
            viewStatistic = null;
        }
        return viewStatistic;


    }

    //  private int countUserCompletedTest(int userId, int testId){
    private int countUserCompletedTest(Statistic statistic) {

        int count = 0;
        List<Statistic> statisticList = statisticService.getFilteredStatisticByTestId(statistic.getQuestion().getTest().getTestId());
        for (Statistic s : statisticList) {
            if (statistic.getUser().getUserId() == s.getUser().getUserId()) {
                count++;
            }
        }
//        List<Statistic> statisticList = statisticService.getFilteredStatisticByTestUser(statistic);
//        statisticList.removeIf( s -> s.getQuestion().getTest().getName() != statistic.getQuestion().getTest().getName()  );;
//        count = statisticList.size();
        return count;
    }


    private int countCorrectAnswer(Statistic statistic) {
        int count = 0;
        List<Statistic> statisticList = statisticService.getFilteredStatisticByTestUser(statistic);

        for (Statistic s : statisticList) {
            if (s.getCorrect() == 1) {
                count++;
            }
        }

        return count;
    }

    public int calculatePercentage(List<Statistic> statisticList){

        int countOfTrueAnswers = 0;
        double countQuestions = statisticList.size();

        for (Statistic statistic : statisticList){
            if (statistic.getCorrect() == 1) countOfTrueAnswers++;
        }
        return  (int) Math.round(countOfTrueAnswers / countQuestions * 100);
    }


    private int countAllAnswer(Statistic statistic) {

        List<Statistic> statisticListTestId = statisticService.getFilteredStatisticByTestId(statistic.getQuestion().getTest().getTestId());
        List<Statistic> statisticListUserId = statisticService.getFilteredStatisticByUserId(statistic.getUser().getUserId(), statisticListTestId);
        //statisticService.getAllStatisticByTestId(statistic.getQuestion().getTest().getTestId());

        return statisticListUserId.size();
    }

    public List<ViewStatistic> getUserTestStatisticList() {

        List<ViewStatistic> userTestInfoList = new ArrayList<>();
        ViewStatistic viewStatistic;
        List<Statistic> statisticList = statisticService.findAll();
        for (Statistic statistic : statisticList) {
            viewStatistic = getUserTestInfo(statistic);
            if (viewStatistic != null) {
                userTestInfoList.add(viewStatistic);
            }
        }
        // сортировка списка по названию FIO
        Set<ViewStatistic> set = new HashSet<>(userTestInfoList);
        userTestInfoList.clear();
        userTestInfoList.addAll(set);
        userTestInfoList.sort(Comparator.comparing(ViewStatistic::getFIO));

        return userTestInfoList;
    }


}
