package incubator.service;

import incubator.config.HibernateConfig;
import incubator.config.WebConfig;
import incubator.dao.AnswerRepository;
import incubator.model.Answer;
import incubator.model.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.Assert.*;

@ComponentScan(basePackages = "incubator")
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
@WebAppConfiguration
@PropertySource("classpath:db.properties")
@PropertySource(value = "classpath:hibernate.properties")
public class StatisticServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private StatisticService statisticService;

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    @Test
    public void showAll() {
        for (int i = 1; i < 6; i++) {
            statisticService.userStatistic(i);
        }
    }


    @Test
    public void save() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Statistic statistic = new Statistic();

        statistic.setCorrect(1);
        statistic.setDate(formatter.format(new Date()));
        statistic.setQuestion(questionService.getQuestionByDescription("First question"));
        statistic.setUser(userService.getUserByUsername("GavinBelson"));

        statisticService.testMethod(statistic);

    }

}
