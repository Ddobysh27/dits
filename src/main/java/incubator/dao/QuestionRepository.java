package incubator.dao;

import incubator.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
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

    @Transactional
    public double testsDifficulty(int x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/managementsystem", "root", "123qwe");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select   questiondifficulty("+x+")");
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
