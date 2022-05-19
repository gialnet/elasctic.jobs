package com.vivaldi.spring.elastic.jobs.data;

import lombok.*;
import org.springframework.data.annotation.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class SearchBox {

    @Id
    String id;
    String queryString;
}
