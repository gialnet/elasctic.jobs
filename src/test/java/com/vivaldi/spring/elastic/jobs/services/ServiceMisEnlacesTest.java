package com.vivaldi.spring.elastic.jobs.services;

import com.vivaldi.spring.elastic.jobs.data.MisEnlaces;
import com.vivaldi.spring.elastic.jobs.repositories.MisEnlacesRepo;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ServiceMisEnlacesTest {

    MisEnlaces enlaces;
    @Autowired
    MisEnlacesRepo misEnlacesRepo;

    @Autowired
    ServiceMisEnlaces serviceMisEnlaces;

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

    @Test
    void processSearch() {
        List<MisEnlaces> linkMatches = new ArrayList<MisEnlaces>();

        linkMatches = serviceMisEnlaces.processSearch("DNS");
        System.out.println(linkMatches.size());
        System.out.println(linkMatches.get(0).getDescription());
        assertTrue( linkMatches.size() > 0 );
    }

    @Test
    void searchById(){

        Optional<MisEnlaces> enlaceID=serviceMisEnlaces.findById("voEeuIAB16vbiDSDm7Jo");
        if ( enlaceID.isPresent()){
            enlaceID.get();
            System.out.println(enlaceID.get().getDescription());
            assertTrue(1 > 0);
        }
        else assertTrue(0 > 1);


    }
}