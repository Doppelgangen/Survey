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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            @RequestParam("choice4") String choice4
    ) {
        Survey survey = new Survey();
        Question question = new Question();

        surveyService.saveChoices(question, choice1, choice2, choice3, choice4);
        question.setQuestionName(questionName);
        question.setSurvey(survey);
        if (isRadio.equals("radio"))
            question.setRadioButton(true);

        survey.setName(surveyName);

        questionRepository.save(question);
        return "redirect:/surveys/testModelGet";
    }

        @PostMapping(path = "/save/all")
        public String saveAll(@ModelAttribute(name = "question") Survey survey,
                              @RequestParam(name = "surveyId") Integer surveyId,
                              @RequestParam(name = "questionId") Integer questionId,
                              @RequestParam(name = "choicesId") String choicesId,
                              @RequestParam(name = "choiceName") String... choices)
        {
            Optional<Question> question = questionRepository.findById(questionId);

            return "redirect:/";
        }

    @GetMapping(path = "/testModelGet")
    public String testModelGet(Model model
//                               @ModelAttribute(name = "survey") Survey survey
    ) {
        Iterable<Survey> surveys = surveyRepository.findAll();
//        model.addAttribute("surveys", surveyRepository.findById(1));
        model.addAttribute("surveys", surveys);
//        Iterable<Question> questions = questionRepository.findAll();
//        model.addAttribute("questions", questions);
//        Iterable<Choice> choices = choiceRepository.findAll();
//        model.addAttribute("choices", choices);
        return "testingModel";
    }

    @PostMapping(path = "/testModelPost")
    public String testModelPost(
//            @ModelAttribute(name = "choice") Choice choice,
                                @ModelAttribute(name = "surveys") Survey survey
    ) {
        return "testingModel";
    }
}
