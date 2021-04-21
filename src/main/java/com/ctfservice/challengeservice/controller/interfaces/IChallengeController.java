package com.ctfservice.challengeservice.controller.interfaces;

import com.ctfservice.challengeservice.model.entity.Challenges;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping
public interface IChallengeController {

    @GetMapping("/")
    Iterable<Challenges> getAll();

    @GetMapping("/{id}")
    Optional<Challenges> getById(@PathVariable int id);

    @PostMapping
    ResponseEntity<String> createChallenge(@RequestBody Challenges challenge);

    @PutMapping("/{id}")
    ResponseEntity<Challenges> updateChallenge(@PathVariable int id, @RequestBody Challenges challenge);

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteChallenge(@PathVariable int id);

}
