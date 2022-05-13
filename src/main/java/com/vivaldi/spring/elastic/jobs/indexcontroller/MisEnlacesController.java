package com.vivaldi.spring.elastic.jobs.indexcontroller;

import com.vivaldi.spring.elastic.jobs.data.MisEnlaces;
import com.vivaldi.spring.elastic.jobs.services.ServiceMisEnlaces;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class MisEnlacesController {

    private MisEnlaces misEnlaces;
    private final ServiceMisEnlaces serviceMisEnlaces;

    public MisEnlacesController(ServiceMisEnlaces serviceMisEnlaces) {
        this.serviceMisEnlaces = serviceMisEnlaces;
    }

    @GetMapping("/addnew")
    public String getaddnew(Model model, HttpSession session){

        misEnlaces = MisEnlaces.builder().build();
        model.addAttribute("MisEnlaces", misEnlaces);
        return "addnew";
    }

    @PostMapping("/addnew")
    public String addnew(@ModelAttribute("MisEnlaces")MisEnlaces misEnlaces, HttpSession session){

        if (misEnlaces==null)
            return "addnew";

        serviceMisEnlaces.SaveLink(misEnlaces);

        return "addnew_success";
    }

    @GetMapping("/links/grid")
    public String showForm(Model model, HttpSession session){

        List<MisEnlaces> enlaces = serviceMisEnlaces.processSearch("kubernetes");

        //enlaces.get(0).
        log.info("number of records '{}'",enlaces.size());
        model.addAttribute("enlaces", enlaces);

        return "linksgrid";
    }
}
