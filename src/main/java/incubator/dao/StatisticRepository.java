package incubator.dao;

import incubator.model.Statistic;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticRepository implements DaoRepos<Statistic> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getBeanToBeAutowired() {
        return sessionFactory;
    }


    public void updateTestMethod(Statistic book) {
        sessionFactory.getCurrentSession().merge(book);
    }

}
