package kz.company.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("/")
    public String Hello() {
        return "hello";
    }

    @GetMapping("/my-page")
    public String myPage(@RequestParam(name="title", required=false, defaultValue="My page") String title,
                         @RequestParam(name="name", required=false, defaultValue="Aziz") String name,
                         @RequestParam(name="surname", required=false, defaultValue="Akshabakov") String surname, Model model) {

        model.addAttribute("title", title);
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);

        return "my-page";
    }

}
