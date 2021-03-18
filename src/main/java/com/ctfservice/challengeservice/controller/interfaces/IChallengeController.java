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
    public ResponseEntity<String> createPage(@RequestBody Challenges challenge);

    @PutMapping("/{path}")
    public ResponseEntity<Challenges> updatePage(@PathVariable String path, @RequestBody Challenges page);

    @DeleteMapping("/{path}")
    public ResponseEntity<String> deletePage(@PathVariable String path);

}
