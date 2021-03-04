package org.vikmak.survey.repos;

import org.springframework.data.repository.CrudRepository;
import org.vikmak.survey.model.User;

/**
 * @author Viktor Makarov
 */
public interface UserRepository extends CrudRepository<User, Integer> {

}