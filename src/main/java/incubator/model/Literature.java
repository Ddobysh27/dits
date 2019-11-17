package incubator.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Literature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int literatureId;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionId")
    private Question question;

    @OneToMany(mappedBy = "literature", fetch = FetchType.LAZY)
    private List<Link> links;


    @Override
    public String toString() {
        return "Literature{" +
                "literatureId=" + literatureId +
                ", description='" + description + '\'' +
                ", question=" + question.getDescription() +
                ", links=" + links +
                '}';
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }


    public Literature(String description, Question question) {
        this.description = description;
        this.question = question;
    }

    public Literature() {
    }

    public int getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(int literatureId) {
        this.literatureId = literatureId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
