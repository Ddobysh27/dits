//package incubator.dao;
//
//import incubator.model.Answer;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//
//@Repository
//public class AnswerDAO {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Transactional
//    public Answer save(Answer answer){
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(answer);
//        transaction.commit();
//        session.close();
//        return answer;
//    }
//
//}
