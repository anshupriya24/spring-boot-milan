package com.sample.microservice.awsdynamodb.service;




import com.sample.microservice.awsdynamodb.domain.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TeamService {


    /**
     * create new Team
     *
     * @param Team entity
     * @return entity that created
     */
    Team create(Team Team);

    /**
     * Update Team data
     *
     * @param Team entity
     * @return entity modified
     */
    Team update(Team Team, String id);


    /**
     * get Team by id
     *
     * @param id entity id
     * @return Optional entity Team
     */
    Optional<Team> getById(String id);

    /**
     * Get all entities
     *
     * @return list of entity Team
     */
    List<Team> getAll();

    void delete(String id);

}