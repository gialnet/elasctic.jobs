package com.vivaldi.spring.elastic.jobs.services;

import com.vivaldi.spring.elastic.jobs.data.geonames_cities;
import com.vivaldi.spring.elastic.jobs.repositories.GeoCitiesRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ServiceFindCity {

    private final GeoCitiesRepo geoCitiesRepo;

    public ServiceFindCity(GeoCitiesRepo geoCitiesRepo) {
        this.geoCitiesRepo = geoCitiesRepo;
    }

    public long getListCities(){

        final Page<geonames_cities> cities = geoCitiesRepo.findByName("Madrid", PageRequest.of(0, 250));
        System.out.println(cities.stream().count());
        return cities.stream().count();
    }
}
