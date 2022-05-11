package com.vivaldi.spring.elastic.jobs.indexcontroller;

import com.vivaldi.spring.elastic.jobs.data.MisEnlaces;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MisEnlacesController {

    private MisEnlaces misEnlaces;

    @GetMapping("/addnew")
    public String getaddnew(Model model, HttpSession session){

        misEnlaces = MisEnlaces.builder().build();
        model.addAttribute("MisEnlaces", misEnlaces);
        return "addnew";
    }

    @PostMapping("/addnew")
    public String addnew(@ModelAttribute("MisEnlaces")MisEnlaces misEnlaces, HttpSession session){

        return "addnew";
    }
}
