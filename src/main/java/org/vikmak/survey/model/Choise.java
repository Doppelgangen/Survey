package org.vikmak.survey.model;

import javax.persistence.*;

/**
 * @author Viktor Makarov
 */
@Entity
public class Choise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "choiseName")
    private String choiseName;

    @Column(name = "questionId")
    private int questionId;

    @Column(name = "userChecked")
    private int userChecked = -1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChoiseName() {
        return choiseName;
    }

    public void setChoiseName(String choiseName) {
        this.choiseName = choiseName;
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
