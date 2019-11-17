package incubator.dao;

import incubator.config.HibernateConfig;
import incubator.config.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

//@EnableTransactionManagement
@ComponentScan(basePackages = "incubator")
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
@WebAppConfiguration
@PropertySource("classpath:db.properties")
@PropertySource(value = "classpath:hibernate.properties")
public class TestRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestRepository testRepository;

    @Test
    public void testSave() {
        incubator.model.Test test = new incubator.model.Test();
        testRepository.save(test);
    }

}
