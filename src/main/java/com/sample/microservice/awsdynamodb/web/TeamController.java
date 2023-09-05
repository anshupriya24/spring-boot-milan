package com.sample.microservice.awsdynamodb.web;


import com.sample.microservice.awsdynamodb.domain.Team;
import com.sample.microservice.awsdynamodb.exception.DataNotFoundException;
import com.sample.microservice.awsdynamodb.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService TeamService) {
        this.teamService = TeamService;
    }


    @GetMapping()
    public List<Team> all() {
        return teamService.getAll();

    }

    @PostMapping()
    public Team save(@RequestBody Team Team) {
        return teamService.create(Team);
    }

    @PutMapping(value = "/{id}")
    public Team update(@PathVariable("id") String id, @RequestBody Team Team) {
        return teamService.update(Team,id);
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable(value = "id") String id) {
        return teamService.getById(id).orElseThrow(() -> new DataNotFoundException("not found"));
    }
    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable(value = "id") String id) {
        teamService.delete(id);
    }

}
