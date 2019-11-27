package incubator.dao;

import incubator.model.Test;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class TestRepository implements DaoRepos<Test> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getBeanToBeAutowired() {
        return sessionFactory;
    }

    public double testsDifficulty(int x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/managementsystem", "root", "123qwe");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select   testdifficulty("+x+")");
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
