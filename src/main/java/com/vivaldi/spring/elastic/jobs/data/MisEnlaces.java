package com.vivaldi.spring.elastic.jobs.data;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "mis-enlaces")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MisEnlaces {

    @Id
    String email;
    String description;
    String link;
    String tags;
}
