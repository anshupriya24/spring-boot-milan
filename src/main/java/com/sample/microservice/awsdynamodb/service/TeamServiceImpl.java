package com.sample.microservice.awsdynamodb.service;

import com.sample.microservice.awsdynamodb.domain.Team;
import com.sample.microservice.awsdynamodb.exception.DataNotFoundException;
import com.sample.microservice.awsdynamodb.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository repository;

    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Team create(Team team) {
        return repository.save(team);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Team update(Team team, String id) {

        Optional<Team> teamOptional = repository.findById(id);
        if (teamOptional.isPresent()) {
        	teamOptional.get().setName(team.getName());
        	teamOptional.get().setMembers(team.getMembers());
        	teamOptional.get().setLead(team.getLead());
        	teamOptional.get().setGroup(team.getGroup());

            return repository.save(teamOptional.get());
        }
        throw new DataNotFoundException("Team Id not found");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Team> getById(String id) {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Team> getAll() {
        return (List<Team>) repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}