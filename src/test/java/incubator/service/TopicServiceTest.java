package incubator.service;

import incubator.config.HibernateConfig;
import incubator.config.WebConfig;
import incubator.model.Topic;
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
public class TopicServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    TopicService topicService;

    @Test
    public void testGetTopics() {
        for (Topic t: topicService.getTopics()
             ) {
            System.out.println(t);

        }
    }
}