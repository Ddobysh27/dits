package incubator.service;

import incubator.config.HibernateConfig;
import incubator.config.WebConfig;
import incubator.dao.AnswerRepository;
import incubator.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@ComponentScan(basePackages = "incubator")
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
@WebAppConfiguration
@PropertySource("classpath:db.properties")
@PropertySource(value = "classpath:hibernate.properties")
public class TopicTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TopicService topicService;

    @Test
    public void showAll() {
        for (String str : topicService.getTestsByTopic("Second topic")
        ) {
            System.out.println(str);
        }
    }

}
