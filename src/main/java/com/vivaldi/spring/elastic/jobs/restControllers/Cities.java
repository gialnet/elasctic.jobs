package com.vivaldi.spring.elastic.jobs.restControllers;

import com.vivaldi.spring.elastic.jobs.services.ServiceFindCity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Cities {

    private final ServiceFindCity serviceFindCity;
    Map<String, Object> response = new HashMap<>();

    public Cities(ServiceFindCity serviceFindCity) {
        this.serviceFindCity = serviceFindCity;
    }

    @GetMapping("/city")
    private ResponseEntity<?> getCities(){
        response.clear();
        response.put("how many?: ", serviceFindCity.getListCities());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
