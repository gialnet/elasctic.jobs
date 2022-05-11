package com.vivaldi.spring.elastic.jobs.services;

import com.vivaldi.spring.elastic.jobs.data.MisEnlaces;
import com.vivaldi.spring.elastic.jobs.repositories.MisEnlacesRepo;
import org.springframework.stereotype.Service;

@Service
public class ServiceMisEnlaces {

    private final MisEnlacesRepo misEnlacesRepo;

    //private MisEnlaces misEnlaces;

    public ServiceMisEnlaces(MisEnlacesRepo misEnlacesRepo) {
        this.misEnlacesRepo = misEnlacesRepo;
    }

    public void SaveLink(MisEnlaces enlaces){

        misEnlacesRepo.save(enlaces);
    }
}
