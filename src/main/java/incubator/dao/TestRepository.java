package incubator.dao;

import incubator.model.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TestRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Test save(Test test) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(test);
        transaction.commit();
        session.close();
        return test;
    }

    @Transactional
    public List<Test> findAll() {
        List<Test> tests = (List<Test>) sessionFactory.openSession().createQuery("From Test").list();
        return tests;
    }

}
