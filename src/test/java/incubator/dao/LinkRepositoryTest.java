package incubator.dao;

import incubator.config.HibernateConfig;
import incubator.config.WebConfig;
import incubator.model.Link;
import incubator.model.Literature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@ComponentScan(basePackages = "incubator")
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
@WebAppConfiguration
@PropertySource("classpath:db.properties")
@PropertySource(value = "classpath:hibernate.properties")
public class LinkRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private LinkRepository linkRepository;

    @Test
    public void showAll() {
        for (Link l : linkRepository.findAll()
        ) {
            System.out.println(l);
        }
    }

}
