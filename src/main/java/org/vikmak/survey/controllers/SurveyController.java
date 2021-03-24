package org.vikmak.survey.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.vikmak.survey.model.Choice;
import org.vikmak.survey.repos.ChoiceRepository;
import org.vikmak.survey.repos.QuestionRepository;
import org.vikmak.survey.repos.SurveyRepository;
import org.vikmak.survey.repos.UserRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Viktor Makarov
 */
@Controller
@RequestMapping(path = "/surveys")
public class SurveyController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ChoiceRepository choiceRepository;

    @GetMapping(path = "/newSurvey")
    public String newSurvey(@ModelAttribute(name = "choices") Choice choice){ return "newSurvey";
    }

    @PostMapping(path = "/addSurvey")
    public @ResponseBody
    String addSurvey(
            @RequestParam("surveyName") String s1,
            @RequestParam("flexRadioDefault") String s4,
            @ModelAttribute(name = "choices") Choice choice,
            @RequestParam("surveyField2") String s3
    ){
        String s = "";

        s+=s1;
        s+=s3;
        if (s4.equals("radio"))
            s+=true;
        else
            s+=false;
        return s;
    }

    @GetMapping(path = "/testModelGet")
    public String testModelGet(@ModelAttribute(name = "choice") Choice choice){
        return "testingModel";
    }

    @PostMapping(path = "/testModelPost")
    public String testModelPost(@ModelAttribute(name = "choice") Choice choice){
        return "testingModel";
    }

}
