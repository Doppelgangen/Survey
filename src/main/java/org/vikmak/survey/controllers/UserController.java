package org.vikmak.survey.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.vikmak.survey.model.*;
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
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ChoiceRepository choiceRepository;


    @PostMapping(path="/add")
    public @ResponseBody
    String addNewUser (@RequestParam String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return "Saved " + user.getId() + " " + user.getPassword();
    }

    @GetMapping(path="/all")
    public String getAllUsers(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping(path = "/newUser")
    public String newUser(@ModelAttribute User user){
        return "newUser";
    }

    @PostMapping(path = "/addUser")
    public @ResponseBody String addUser(@ModelAttribute User user){
        Set<Role> roles = new HashSet<>();

//        Setting default role as User
        roles.add(Role.USER);
        user.setRoles(roles);
        userRepository.save(user);
        return "Success";
    }

}
