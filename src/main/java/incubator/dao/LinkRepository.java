package incubator.dao;


import incubator.model.Link;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LinkRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public Link save(Link link) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(link);
        transaction.commit();
        session.close();
        return link;
    }

    @Transactional
    public List<Link> findAll() {
        List<Link> links = (List<Link>) sessionFactory.openSession().createQuery("From Link").list();
        return links;
    }
}
