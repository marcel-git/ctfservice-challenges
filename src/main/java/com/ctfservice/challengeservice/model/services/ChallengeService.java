package com.ctfservice.challengeservice.model.services;

import com.ctfservice.challengeservice.model.entity.Challenges;
import com.ctfservice.challengeservice.payload.SolutionSubmission;
import com.ctfservice.challengeservice.repository.IChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {

    @Autowired
    private IChallengeRepository challengeRepository;

    /**
     * Gets all challenges from the repository and deletes the solution, so they are not send to the client.
     * **/
    public Iterable<Challenges> getAll() {
        List<Challenges> results =  challengeRepository.findAll();
        for (Challenges challenge: results) {
            challenge.setSolution("");
        }
        return results;
    }

    /**
     * Gets a challenge from the repository by its ID and deletes the solution, so it is not send to the client.
     * **/
    public Optional<Challenges> getById(int id) {
        Optional<Challenges> result = challengeRepository.findById(id);
        if(result.isPresent()){
            result.get().setSolution("");
        }
        return result;
    }

    /**
     * Creates a new challenge and saves it into the database
     * @param challenge
     * @return HTTP.ok if the challenge fulfilled the criteria or HTTP.badRequest if either the name or the solution is already present.
     */
    public ResponseEntity<String> createPage(Challenges challenge) {
        if(challengeRepository.existsByName(challenge.getName())){
            return ResponseEntity.badRequest().body("Error: Name is already taken");
        }
        if(challengeRepository.existsBySolution(challenge.getSolution())){
            return ResponseEntity.badRequest().body("Error: Solution is already in use");
        }
        challengeRepository.save(challenge);
        return ResponseEntity.ok("Challenge created successfully");
    }

    public ResponseEntity<Challenges> updatePage(String path, Challenges page) {
        return null;
    }

    public ResponseEntity<String> deletePage(String path) {
        return null;
    }

    public ResponseEntity<String> verifyFlag(SolutionSubmission submission) {
        String flag = submission.getSolution();
        int id = submission.getChallengeID();
        Optional<Challenges> result = challengeRepository.findById(id);
        if(result.isPresent()){
            Challenges challenge = result.get();
            if(challenge.getSolution().equals(flag)){
                //TODO if the flag was correct, insert team and challenge id into "solved", as well as checking for first blood
                return ResponseEntity.ok().body("Success: Flag was correct!");
            }else {
                //TODO Maybe use a different HTTP code for failing the test
                return ResponseEntity.ok().body("Error: Flag was wrong!");
            }
        }else {
            return ResponseEntity.badRequest().body("Error: Wrong challenge id");
        }

    }
}
