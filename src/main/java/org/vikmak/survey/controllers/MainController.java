package org.vikmak.survey.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.vikmak.survey.model.Choise;
import org.vikmak.survey.model.Question;
import org.vikmak.survey.model.Survey;
import org.vikmak.survey.model.User;
import org.vikmak.survey.repos.ChoiseRepository;
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
    private ChoiseRepository choiseRepository;

    @GetMapping
    public String hello(){
        return "greeting";
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        userRepository.save(n);

        Survey survey = new Survey();
        survey.setAuthor(n.getId());
        surveyRepository.save(survey);

        Question question = new Question();
        question.setSurveyId(survey.getId());
        questionRepository.save(question);

        Choise choise = new Choise();
        choise.setQuestionId(question.getId());
        choiseRepository.save(choise);
        return "Saved " + n.getId() + " " + n.getPassword();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path = "/main")
    public String mainPage() {
        return "main";
    }

    @GetMapping(path = "/newUser")
    public String newUser(@ModelAttribute User user){
        return "newUser";
    }

    @PostMapping(path = "/addUser")
    public @ResponseBody String addUser(@ModelAttribute User user){
        userRepository.save(user);
        return "Success";
    }

    @GetMapping(path = "/newSurvey")
    public String newSurvey(Model model){
        return "newSurvey";
    }

    @PostMapping(path = "/addSurvey")
    public @ResponseBody String addSurvey(
            @RequestParam("surveyName") String s1,
            @RequestParam("surveyField") String s2,
            @RequestParam("surveyField2") String s3
    ){
        String s = "";
        s+=s1;
        s+=s2;
        s+=s3;
        return s;
    }

}