package org.vikmak.survey.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Viktor Makarov
 */
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "questionName")
    private String questionName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Choice> choices;

    @Column(name = "radioButton")
    private boolean radioButton = false;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public boolean getRadioButton() {
        return radioButton;
    }

    public void setRadioButton(boolean radioButton) {
        this.radioButton = radioButton;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionName='" + questionName + '\'' +
                ", choices=" + choices +
                ", radioButton=" + radioButton +
                '}';
    }
}
