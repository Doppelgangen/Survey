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

    @Column(name = "surveyId")
    private int surveyId;

    @Column(name = "choices")
    @ElementCollection(targetClass = Integer.class, fetch = FetchType.LAZY)
    private List<Integer> choisesId;

    @Column(name = "isRadioButton")
    private boolean isRadioButton;

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

    public List<Integer> getChoisesId() {
        return choisesId;
    }

    public void setChoisesId(List<Integer> choisesId) {
        this.choisesId = choisesId;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public boolean isRadioButton() {
        return isRadioButton;
    }

    public void setRadioButton(boolean radioButton) {
        isRadioButton = radioButton;
    }
}
