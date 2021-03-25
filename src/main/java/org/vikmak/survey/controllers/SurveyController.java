package org.vikmak.survey.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.vikmak.survey.model.Choice;
import org.vikmak.survey.model.Question;
import org.vikmak.survey.model.Survey;
import org.vikmak.survey.repos.ChoiceRepository;
import org.vikmak.survey.repos.QuestionRepository;
import org.vikmak.survey.repos.SurveyRepository;
import org.vikmak.survey.repos.UserRepository;
import org.vikmak.survey.service.SurveyService;

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
    @Autowired
    private SurveyService surveyService;

    @GetMapping(path = "/newSurvey")
    public String newSurvey(Model model) {
        return "newSurvey";
    }

    @PostMapping(path = "/addSurvey")
    public String addSurvey(
            @RequestParam("surveyName") String surveyName,
            @RequestParam("flexRadioDefault") String isRadio,
            @RequestParam("questionName") String questionName,
            @RequestParam("choice1") String choice1,
            @RequestParam("choice2") String choice2,
            @RequestParam("choice3") String choice3,
            @RequestParam("choice4") String choice4,
            @ModelAttribute(name = "choices") Choice choice
    ) {
        Survey survey = new Survey(surveyName);
        Question question = new Question();

        surveyService.saveChoices(question, choice1, choice2, choice3, choice4);
        question.setQuestionName(questionName);
        question.setSurvey(survey);
        if (isRadio.equals("radio"))
            question.setRadioButton(true);

        questionRepository.save(question);
//        surveyRepository.save(survey);

        return "redirect:/surveys/testModelGet";
    }

    @GetMapping(path = "/testModelGet")
    public String testModelGet(Model model
//                               @ModelAttribute(name = "survey") Survey survey
    ) {
        Iterable<Survey> surveys = surveyRepository.findAll();
        model.addAttribute("surveys", surveys);
        Iterable<Question> questions = questionRepository.findAll();
        model.addAttribute("questions", questions);
        Iterable<Choice> choices = choiceRepository.findAll();
        model.addAttribute("choices", choices);
        return "testingModel";
    }

    @PostMapping(path = "/testModelPost")
    public String testModelPost(
//            @ModelAttribute(name = "choice") Choice choice,
//                                @ModelAttribute(name = "survey") Survey survey
    ) {
        return "testingModel";
    }
}
