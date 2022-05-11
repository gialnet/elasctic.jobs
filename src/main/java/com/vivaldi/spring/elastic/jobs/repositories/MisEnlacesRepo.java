package com.vivaldi.spring.elastic.jobs.repositories;

import com.vivaldi.spring.elastic.jobs.data.MisEnlaces;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MisEnlacesRepo extends ElasticsearchRepository<MisEnlaces, String> {

}
