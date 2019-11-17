package incubator.dao;

import incubator.model.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class AnswerRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Answer save(Answer answer){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(answer);
        transaction.commit();
        session.close();
        return answer;
    }

    @Transactional
    public List<Answer> findAll() {
        List<Answer> answers = (List<Answer>) sessionFactory.openSession().createQuery("From Answer").list();
        return answers;
    }

}
