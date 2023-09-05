package com.sample.microservice.awsdynamodb.service;




import com.sample.microservice.awsdynamodb.domain.Assessment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AssessmentService {


    /**
     * create new employee
     *
     * @param employee entity
     * @return entity that created
     */
    Assessment create(Assessment employee);

    /**
     * Update employee data
     *
     * @param employee entity
     * @return entity modified
     */
    Assessment update(Assessment employee, String id);


    /**
     * get Employee by id
     *
     * @param id entity id
     * @return Optional entity Employee
     */
    Optional<Assessment> getById(String id);

    /**
     * Get all entities
     *
     * @return list of entity Employee
     */
    List<Assessment> getAll();

    void delete(String id);

}