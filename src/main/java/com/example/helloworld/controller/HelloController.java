package com.example.helloworld.controller;

import com.example.helloworld.entity.Person;
import com.example.helloworld.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    // @GetMapping maps / to the index() method. When invoked from a browser or by using curl
    // on the command line, the method returns pure text. This is because @RestController combines
    // @Controller and @ResponseBody, two annotations that results in web requests returning
    // data rather than a view
    @GetMapping("/")
    public String getHandler(ModelMap model) {
        model.addAttribute("key", "Welcome to the home page!");
        return "index";
    }

    @PostMapping("/hellopost")
    // the requestParam should match the html name attribute
    public String postRequest(@RequestParam ("anything") String input, Model model) {
        model.addAttribute("userInput", input);
        return "response";
    }

    @PostMapping("/back")
    public String goBack() {
        return "index";
    }

    @PostMapping("/checkPerson")
    public String getPersonRequest(@RequestParam ("pid") String id, Model model) {
        Person person = helloService.getPerson(id);
        model.addAttribute("p1", person);
        return "dbResult";
    }
}
