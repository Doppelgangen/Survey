package org.vikmak.survey.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Viktor Makarov
 */
@Entity
@Table(name = "survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private int author;

    @Column(name = "questionId")
    @ElementCollection(targetClass = Integer.class, fetch = FetchType.EAGER)
    private List<Integer> questionId;

    @Column(name = "userPassed")
    private int passedId = -1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getQuestionId() {
        return questionId;
    }

    public void setQuestionId(List<Integer> questionId) {
        this.questionId = questionId;
    }

    public int getPassedId() {
        return passedId;
    }

    public void setPassedId(int passedId) {
        this.passedId = passedId;
    }
}
