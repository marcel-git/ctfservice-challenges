package com.ctfservice.challengeservice.controller.interfaces;

import com.ctfservice.challengeservice.payload.SolutionSubmission;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface IVerificationController {

    @PostMapping
    ResponseEntity<String> verifyFlag(@RequestBody SolutionSubmission submission);

}
