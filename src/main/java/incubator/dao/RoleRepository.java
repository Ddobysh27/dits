package incubator.dao;


import incubator.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class RoleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Role save(Role role){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(role);
        transaction.commit();
        session.close();
        return role;
    }

    @Transactional
    public List<Role> findAll() {
        List<Role> roles = (List<Role>) sessionFactory.openSession().createQuery("From Role").list();
        return roles;
    }

}
