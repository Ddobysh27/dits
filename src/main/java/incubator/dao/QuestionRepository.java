package incubator.dao;

import incubator.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class QuestionRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Question save(Question question) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(question);
        transaction.commit();
        session.close();
        return question;
    }

    @Transactional
    public List<Question> findAll() {
        List<Question> questions = (List<Question>) sessionFactory.openSession().createQuery("From Question").list();
        return questions;
    }

}
