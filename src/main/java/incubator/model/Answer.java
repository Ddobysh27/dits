package incubator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerId;
    private String description;
    private String correct;
    //private int questionId;

    public Answer(String description, String correct) {
        this.description = description;
        this.correct = correct;
    }
}
