package incubator.dao;

import incubator.model.Statistic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StatisticRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Statistic save(Statistic statistic) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(statistic);
        transaction.commit();
        session.close();
        return statistic;
    }

    @Transactional
    public List<Statistic> findAll() {
        List<Statistic> statistics = (List<Statistic>) sessionFactory.openSession().createQuery("From Statistic").list();
        return statistics;
    }
}
