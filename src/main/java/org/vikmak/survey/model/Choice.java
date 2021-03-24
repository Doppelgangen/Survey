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
    private String choiceName;

    @Column(name = "questionId")
    private int questionId;

    @Column(name = "userChecked")
    private int userChecked = -1;

    public Choice() {
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

    public void setChoiceName(String choiseName) {
        this.choiceName = choiseName;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getUserChecked() {
        return userChecked;
    }

    public void setUserChecked(int userChecked) {
        this.userChecked = userChecked;
    }
}
