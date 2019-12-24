package incubator.service;

import incubator.config.HibernateConfig;
import incubator.config.WebConfig;
import incubator.dao.AnswerRepository;
import incubator.model.Answer;
import incubator.model.Question;
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
public class TestServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestService testService;

    @Test
    public void showAll() {
        for (Question question : testService.getQuestionsByTest("First test")
        ) {
            System.out.println(question);
        }
    }

    @Test
    public void testByName() {
        System.out.println(testService.getTestByName("First test"));
    }

    @Test
    public void getAllTests(){
        for (incubator.model.Test t: testService.getAllTests()
             ) {
            System.out.println(t);
        }
    }


}
