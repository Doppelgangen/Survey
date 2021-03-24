package org.vikmak.survey.repos;

import org.springframework.data.repository.CrudRepository;
import org.vikmak.survey.model.Choice;

/**
 * @author Viktor Makarov
 */
public interface ChoiceRepository extends CrudRepository<Choice, Integer> {
}
