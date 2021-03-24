package org.vikmak.survey.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.vikmak.survey.repos.ChoiceRepository;
import org.vikmak.survey.repos.QuestionRepository;
import org.vikmak.survey.repos.SurveyRepository;
import org.vikmak.survey.repos.UserRepository;

/**
 * @author Viktor Makarov
 */
@Controller
public class MainController {

//    Adding all tables
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ChoiceRepository choiceRepository;

    @GetMapping
    public String hello(){
        return "greeting";
    }

    @GetMapping(path = "/main")
    public String mainPage() {
        return "main";
    }

}