package incubator.dao;

import incubator.config.HibernateConfig;
import incubator.model.Topic;
import incubator.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.testng.annotations.Test;

@ComponentScan(basePackages = "incubator")
@EnableTransactionManagement
@ContextConfiguration(classes = {HibernateConfig.class})
@WebAppConfiguration
@PropertySource("classpath:db.properties")
@PropertySource(value = "classpath:hibernate.properties")
public class TopicRepositoryTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private TopicRepository topicRepository;

    @Test
    public void testSave() {
        Topic topic = new Topic();
        topicRepository.save(topic);
    }
}