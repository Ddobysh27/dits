package incubator.service;

import incubator.dao.TestRepository;
import incubator.model.Question;
import incubator.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;


    public Test getTestByName(String testName) {
        List<Test> testList = testRepository.findAll(Test.class, testRepository.getBeanToBeAutowired());
        Test outTest = new Test();
        if (testList.toString().contains(testName)) {
            for (Test test : testList
            ) {
                if (test.getName().equals(testName)) {
                    outTest = test;
                }
            }
        } else {
            System.out.println("Всё плохо, такого теста нет");
        }
        return outTest;
    }

    public List<Question> getQuestionsByTest(String testName) {
        List<Test> tests = testRepository.findAll(Test.class, testRepository.getBeanToBeAutowired());
        List<Question> str = new ArrayList<>();

        if (tests.toString().contains(testName)) {
            for (Test test : tests) {
                if (test.getName().equals(testName)) {
                    for (Question question : test.getQuestions()
                    ) {
                        str.add(question);
                    }
                }
            }
        } else {
            System.out.println("Всё плохо, такой тест не найден");
        }
        return str;
    }

}
