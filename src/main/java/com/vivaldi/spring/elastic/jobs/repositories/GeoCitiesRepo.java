package com.vivaldi.spring.elastic.jobs.repositories;

import com.vivaldi.spring.elastic.jobs.data.geonames_cities;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface GeoCitiesRepo extends ElasticsearchRepository<geonames_cities, String> {
    Page<geonames_cities> findByName(String name, Pageable pageable);
}
