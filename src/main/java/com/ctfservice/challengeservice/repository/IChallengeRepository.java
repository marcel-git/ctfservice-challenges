package com.ctfservice.challengeservice.repository;

import com.ctfservice.challengeservice.model.entity.Challenges;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IChallengeRepository extends JpaRepository<Challenges, Integer>{

    Optional<Challenges> findById(int id);

    Boolean existsByName(String name);
    Boolean existsBySolution(String solution);

}
