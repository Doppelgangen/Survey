package org.vikmak.survey.repos;

import org.springframework.data.repository.CrudRepository;
import org.vikmak.survey.model.Choise;

/**
 * @author Viktor Makarov
 */
public interface ChoiseRepository extends CrudRepository<Choise, Integer> {
}
