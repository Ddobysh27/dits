package incubator.dao;

import incubator.config.HibernateConfig;
import incubator.config.WebConfig;

import incubator.model.Role;
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
public class RoleRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void showAll() {
        for (Role r : roleRepository.findAll()
        ) {
            System.out.println(r);
        }
    }

}
