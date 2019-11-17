package incubator.dao;

import incubator.model.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ParameterMode;
import java.sql.*;
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

    @Transactional
    public double testsDifficulty(int x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/managementsystem", "root", "123qwe");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select   difficultyrate("+x+")");
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (ClassNotFoundException ex1) {
            System.out.println("Class not found EX " + ex1.getMessage());
        } catch (SQLException ex2) {
            System.out.println("SQL EX " + ex2.getMessage());
        }
        return 1;
    }

}
