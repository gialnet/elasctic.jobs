package com.vivaldi.spring.elastic.jobs.indexcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class home {

    @GetMapping("/")
    public String root(HttpSession session) {

        log.info("index '{}'", session.getAttribute("id"));
        return "index";
    }
}
