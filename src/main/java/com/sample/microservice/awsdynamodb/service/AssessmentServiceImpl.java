package com.sample.microservice.awsdynamodb.service;

import com.sample.microservice.awsdynamodb.domain.Assessment;
import com.sample.microservice.awsdynamodb.exception.DataNotFoundException;
import com.sample.microservice.awsdynamodb.repository.AssessmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentRepository repository;

    public AssessmentServiceImpl(AssessmentRepository repository) {
        this.repository = repository;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Assessment create(Assessment assessment) {
        return repository.save(assessment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Assessment update(Assessment assessment, String id) {

        Optional<Assessment> assessmentOptional = repository.findById(id);
        if (assessmentOptional.isPresent()) {
            assessmentOptional.get().setTitle(assessment.getTitle());
            assessmentOptional.get().setDescription(assessment.getDescription());
            assessmentOptional.get().setLink(assessment.getLink());
            assessmentOptional.get().setGroupName(assessment.getGroupName());
            

            return repository.save(assessmentOptional.get());
        }
        throw new DataNotFoundException("assessment Id not found");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Assessment> getById(String id) {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Assessment> getAll() {
        return (List<Assessment>) repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}