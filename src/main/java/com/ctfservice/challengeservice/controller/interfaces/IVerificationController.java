package com.ctfservice.challengeservice.controller.interfaces;

import com.ctfservice.challengeservice.payload.SolutionSubmission;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface IVerificationController {

    @GetMapping("/")
    public ResponseEntity<String> verifyFlag(@RequestBody SolutionSubmission submission);

}
