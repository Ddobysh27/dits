package incubator.dao;

import incubator.model.Question;
import incubator.model.Statistic;
import incubator.service.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;
import java.util.Date;

@Repository
public class StatisticRepository implements DaoRepos<Statistic> {

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getBeanToBeAutowired() {
        return sessionFactory;
    }

    public List<Statistic> personalUserTestStatistic(String userId, String start, String end) {
        List<Statistic> statisticList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/managementsystem?verifyServerCertificate=false&useSSL=true", "root", "123qwe");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("call personalUserTestStatistic(" + userId + ", '" + start + "', '" + end + "')");
            while (rs.next()) {
                Statistic statistic = new Statistic.Builder()
                        .withId(rs.getInt(1))
                        .withDate(rs.getString(2))
                        .withCorrect(rs.getInt(3))
                        .withQuestion(questionService.getQuestionById(rs.getInt(4)))
                        .withUser(userService.getUserByUserId(rs.getInt(5)))
                        .create();
                statisticList.add(statistic);
            }
        } catch (ClassNotFoundException ex1) {
            System.out.println("Class not found EX " + ex1.getMessage());
        } catch (SQLException ex2) {
            System.out.println("SQL EX " + ex2.getMessage());
        }
        return statisticList;
    }

    public List<QuestionStatModel> personalUserStatistic(int userId) {
        List<Statistic> statisticList = userService.getUserByUserId(userId).getStatistics();
        Set<Question> questionSet = new HashSet<>();
        List<QuestionStatModel> statList = new ArrayList<>();

        for (Statistic statistic : userService.getUserByUserId(userId).getStatistics()
        ) {
            questionSet.add(statistic.getQuestion());
        }

        for (Question q : questionSet
        ) {
            int questionRate = 0;
            int answerCount = 0;
            double correctCOunt = 0;
            String FIO = "";
            String testName = "";
            String questionDescription = "";
            for (Statistic st : statisticList
            ) {
                if (q.getQuestionId() == st.getQuestion().getQuestionId()) {
                    testName = st.getQuestion().getTest().getName();
                    questionDescription = st.getQuestion().getDescription();
                    FIO = st.getUser().getFIO(st.getUser());
                    answerCount++;
                    if (st.getCorrect() == 1) {
                        correctCOunt++;
                    }
                }
            }
            questionRate = (int) ((correctCOunt / answerCount) * 100);
            statList.add(new QuestionStatModel(answerCount, questionRate, FIO, testName, questionDescription));
        }
        return statList;
    }





    }