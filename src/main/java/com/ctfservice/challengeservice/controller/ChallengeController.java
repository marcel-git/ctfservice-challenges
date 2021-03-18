package com.ctfservice.challengeservice.controller;

import com.ctfservice.challengeservice.controller.interfaces.IChallengeController;
import com.ctfservice.challengeservice.model.entity.Challenges;
import com.ctfservice.challengeservice.model.services.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/challenge")
public class ChallengeController implements IChallengeController {

    @Autowired
    ChallengeService service;

    @Override
    public Iterable<Challenges> getAll() {
        return service.getAll();
    }

    @Override
    public Optional<Challenges> getById(int id) {
        return service.getById(id);
    }

    @Override
    public ResponseEntity<String> createPage(Challenges challenge) {
        return service.createPage(challenge);
    }

    @Override
    public ResponseEntity<Challenges> updatePage(String path, Challenges page) {
        return null;
    }

    @Override
    public ResponseEntity<String> deletePage(String path) {
        return null;
    }
}
