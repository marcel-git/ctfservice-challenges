package com.ctfservice.challengeservice.controller;

import com.ctfservice.challengeservice.controller.interfaces.IVerificationController;
import com.ctfservice.challengeservice.model.services.ChallengeService;
import com.ctfservice.challengeservice.payload.SolutionSubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/verify")
public class VerificationController implements IVerificationController {

    @Autowired
    ChallengeService service;

    @Override
    public ResponseEntity<String> verifyFlag(SolutionSubmission submission) {
        return service.verifyFlag(submission);
    }
}
