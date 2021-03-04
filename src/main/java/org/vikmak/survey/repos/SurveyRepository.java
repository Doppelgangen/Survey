package org.vikmak.survey.repos;

import org.springframework.data.repository.CrudRepository;
import org.vikmak.survey.model.Survey;

/**
 * @author Viktor Makarov
 */
public interface SurveyRepository extends CrudRepository<Survey, Integer> {
}
