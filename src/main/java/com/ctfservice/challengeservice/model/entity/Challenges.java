package com.ctfservice.challengeservice.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Challenges {

    @Id
    private int id;

    private String name;

    private String text;

    private int points;

    private String solution;

}
