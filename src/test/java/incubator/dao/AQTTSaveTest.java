package incubator.dao;

import incubator.config.HibernateConfig;
import incubator.config.WebConfig;
import incubator.model.Answer;
import incubator.model.Question;
import incubator.model.Topic;
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
public class AQTTSaveTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TopicRepository topicRepository;


    @Test
    public void testSave() {

        Topic topic = new Topic();
        topic.setDescription("Hibernate");
        topic.setName("Topic1");

        incubator.model.Test test = new incubator.model.Test();
        test.setDescription("About hibernate?");
        test.setName("Test1");
        test.setTopic(topic);

        Question question = new Question();
        question.setDescription("What is hibernate?");
        question.setTest(test);

        Answer answer1 = new Answer();
        answer1.setDescription("It is good");
        answer1.setCorrect(true);
        answer1.setQuestion(question);

        Answer answer2 = new Answer();
        answer2.setDescription("It is not good");
        answer2.setCorrect(false);
        answer2.setQuestion(question);

        answerRepository.save(answer1);
        answerRepository.save(answer2);



    }

}