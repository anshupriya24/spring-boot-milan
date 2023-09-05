package com.sample.microservice.awsdynamodb.web;


import com.sample.microservice.awsdynamodb.domain.Assessment;
import com.sample.microservice.awsdynamodb.exception.DataNotFoundException;
import com.sample.microservice.awsdynamodb.service.AssessmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessment")
public class AssessmentController {

    private final AssessmentService assessmentService;

    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }


    @GetMapping()
    public List<Assessment> all() {
        return assessmentService.getAll();

    }

    @PostMapping()
    public Assessment save(@RequestBody Assessment assessment) {
        return assessmentService.create(assessment);
    }

    @PutMapping(value = "/{id}")
    public Assessment update(@PathVariable("id") String id, @RequestBody Assessment assessment) {
        return assessmentService.update(assessment,id);
    }

    @GetMapping("/{id}")
    public Assessment getassessmentById(@PathVariable(value = "id") String id) {
        return assessmentService.getById(id).orElseThrow(() -> new DataNotFoundException("not found"));
    }
    @DeleteMapping("/{id}")
    public void deleteassessment(@PathVariable(value = "id") String id) {
        assessmentService.delete(id);
    }

}
