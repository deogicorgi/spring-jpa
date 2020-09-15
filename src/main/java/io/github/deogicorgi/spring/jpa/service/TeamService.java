package io.github.deogicorgi.spring.jpa.service;

import io.github.deogicorgi.spring.jpa.entity.Team;
import io.github.deogicorgi.spring.jpa.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public Team findById(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        return team.orElseThrow();
    }

    public void remove(Team team){
        teamRepository.delete(team);
    }
}
