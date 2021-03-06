package incubator.service;

import incubator.config.HibernateConfig;
import incubator.config.WebConfig;
import incubator.model.Question;
import incubator.model.Statistic;
import incubator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;


@ComponentScan(basePackages = "incubator")
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
@WebAppConfiguration
@PropertySource("classpath:db.properties")
@PropertySource(value = "classpath:hibernate.properties")
public class UserServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    UserService userService;

    @Autowired
    StatisticService statisticService;

    @Test
    public void testGetUsernames() {
        System.out.println(userService.getUsernames());
    }

    @Test
    public void testUserStatisticThing() {
        List<QuestionStatModel> varList = statisticService.getStatList(1);
        for (QuestionStatModel q : varList
        ) {
            System.out.println(q);
        }
        Collections.sort(varList, new SortByQuestionId());
        for (QuestionStatModel q : varList
        ) {
            System.out.println(q);
        }
    }

    @Test
    public void testGetAllUsers() {
        for (User u: userService.getAllUsers()
             ) {
            System.out.println(u);
        }

    }

}