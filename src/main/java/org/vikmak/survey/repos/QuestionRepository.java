package org.vikmak.survey.repos;

import org.springframework.data.repository.CrudRepository;
import org.vikmak.survey.model.Question;

/**
 * @author Viktor Makarov
 */
public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
