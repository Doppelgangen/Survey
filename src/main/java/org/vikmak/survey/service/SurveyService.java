package org.vikmak.survey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vikmak.survey.model.Choice;
import org.vikmak.survey.model.Question;
import org.vikmak.survey.repos.ChoiceRepository;

/**
 * @author Viktor Makarov
 */
@Service
public class SurveyService {
    @Autowired
    private ChoiceRepository choiceRepository;

    public void saveChoices(Question question, String... args) {
        for (String arg : args) {
            Choice c = new Choice(arg, question);
            choiceRepository.save(c);
        }
    }
}
