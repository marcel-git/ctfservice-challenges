package com.ctfservice.challengeservice.payload;

/**
 * Custom payload object
 */
public class SolutionSubmission {

    private int challengeID;

    private String solution;

    public int getChallengeID(){
        return challengeID;
    }

    public String getSolution(){
        return solution;
    }

}
