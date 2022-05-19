package com.vivaldi.spring.elastic.jobs.services;

import com.vivaldi.spring.elastic.jobs.data.MisEnlaces;
import com.vivaldi.spring.elastic.jobs.repositories.MisEnlacesRepo;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ServiceMisEnlaces {

    private final MisEnlacesRepo misEnlacesRepo;
    private final ElasticsearchOperations elasticsearchOperations;
    private static final String ENLACES_INDEX = "mis-enlaces";

    //private MisEnlaces misEnlaces;

    public ServiceMisEnlaces(MisEnlacesRepo misEnlacesRepo, ElasticsearchOperations elasticsearchOperations) {
        this.misEnlacesRepo = misEnlacesRepo;
        this.elasticsearchOperations = elasticsearchOperations;
    }

    /**
     * Save a link into the index
     * @param enlaces
     */
    public void SaveLink(MisEnlaces enlaces){

        misEnlacesRepo.save(enlaces);

    }

    /**
     * Find by ID and return an Optional with the result
     *
     * @param id
     * @return Optional<MisEnlaces>
     */
    public Optional<MisEnlaces> findById(String id){

        return misEnlacesRepo.findById(id);

    }

    /**
     * get a list of likns
     * @param query
     * @return
     */
    public List<MisEnlaces> processSearch(final String query){

        List<MisEnlaces> linkMatches = new ArrayList<MisEnlaces>();

        log.info("Search with query {}", query);

        // 1. Create query on multiple fields enabling fuzzy search
        QueryBuilder queryBuilder =
                QueryBuilders
                        .multiMatchQuery(query, "link", "description")
                        .fuzziness(Fuzziness.AUTO);

        Query searchQuery = new NativeSearchQueryBuilder()
                .withFilter(queryBuilder)
                .build();

        // 2. Execute search
        SearchHits<MisEnlaces> linksHits =
                elasticsearchOperations
                        .search(searchQuery, MisEnlaces.class,
                                IndexCoordinates.of(ENLACES_INDEX));

        // 3. Map searchHits to link list

        linksHits.forEach(searchHit->{
            linkMatches.add(searchHit.getContent());
        });

        return linkMatches;


    }
}
