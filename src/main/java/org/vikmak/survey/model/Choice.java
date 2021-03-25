package org.vikmak.survey.model;

import javax.persistence.*;

/**
 * @author Viktor Makarov
 */
@Entity
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "choiceName")
    private String choiceName = "noName";

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "userChecked")
    private int userChecked = -1;

    public Choice() {
    }

    public Choice(String choiceName, Question question) {
        this.choiceName = choiceName;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChoiceName() {
        return choiceName;
    }

    public void setChoiceName(String choiceName) {
        this.choiceName = choiceName;
    }

    public int getUserChecked() {
        return userChecked;
    }

    public void setUserChecked(int userChecked) {
        this.userChecked = userChecked;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "id=" + id +
                ", choiceName='" + choiceName + '\'' +
                ", userChecked=" + userChecked +
                '}';
    }
}
