package com.vivaldi.spring.elastic.jobs.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "geonames-cities")
public class geonames_cities {

    @Id
    String admin1_code;
    String admin2_code;
    String admin3_code;
    String admin4_code;
    String alternatenames;
    String asciiname;
    String cc2;
    String country_code;
    Long dem;
    Long elevation;
    String feature_class;
    String feature_code;
    Long geonameid;
    String latitude;
    String longitude;
    String modification_date;
    String name;
    Long population;
    String time_zone;
}
