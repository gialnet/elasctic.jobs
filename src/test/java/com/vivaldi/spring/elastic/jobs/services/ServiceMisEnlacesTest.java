package com.vivaldi.spring.elastic.jobs.services;

import com.vivaldi.spring.elastic.jobs.data.MisEnlaces;
import com.vivaldi.spring.elastic.jobs.repositories.MisEnlacesRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceMisEnlacesTest {

    MisEnlaces enlaces;
    @Autowired
    MisEnlacesRepo misEnlacesRepo;


    @Test
    void saveLink() {

       enlaces=MisEnlaces.builder()
               .email("antonio.gialnet@gmail.com")
               .description("enalce de prueba")
               .link("un link")
               .tags("uno dos tres")
               .build();

       misEnlacesRepo.save(enlaces);

    }
}