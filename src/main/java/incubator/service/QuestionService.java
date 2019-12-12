package incubator.service;


import incubator.dao.QuestionRepository;
import incubator.model.Answer;
import incubator.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<String> getAnswersByQuestion(String questionDescription) {
        List<Question> questions = questionRepository.findAll(Question.class, questionRepository.getBeanToBeAutowired());
        List<String> str = new ArrayList<>();

        if (questions.toString().contains(questionDescription)) {
            for (Question question : questions) {
                if (question.getDescription().equals(questionDescription)) {
                    for (Answer answer : question.getAnswers()
                    ) {
                        str.add(answer.getDescription());
                    }
                }
            }
        } else {
            System.out.println("Всё плохо, такой вопрос не найден");
        }
        return str;
    }

    public Question getQuestionByDescription(String description) {
        Question question = new Question();
        List<Question> questions = questionRepository.findAll(Question.class, questionRepository.getBeanToBeAutowired());
        if (questions.toString().contains(description)) {
            for (Question quest : questions
            ) {
                if (quest.getDescription().equals(description)) {
                    question = quest;
                }
            }
        } else {
            System.out.println("Всё плохо, вопроса в таким описанием нет в БД");
        }
        return question;
    }

}
