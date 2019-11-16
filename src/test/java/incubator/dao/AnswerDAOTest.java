//package incubator.dao;
//
//import incubator.config.HibernateConfig;
//import incubator.config.WebConfig;
//import incubator.model.Answer;
//import incubator.service.AnswerService;
//import org.junit.Test;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//@ComponentScan(basePackages = "incubator")
//@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
//@WebAppConfiguration
//@PropertySource("classpath:db.properties")
//@PropertySource(value = "classpath:hibernate.properties")
//public class AnswerDAOTest extends AbstractTestNGSpringContextTests {
//
////    @Autowired
////    AnswerDAO answerDAO;
//
//    @Test
//    public void save() {
//        //AnswerDAO answerDAO = new AnswerDAO();
//        AnswerService service = new AnswerService();
//        Answer answer = new Answer("String","Varchar");
//        service.save(answer);
//    }
//}