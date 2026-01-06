package com.interview.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Skill evaluation details
 * Part of candidate evaluation response
 */
public class SkillEvaluation {

    @JsonProperty("skill")
    private String skill;

    @JsonProperty("score")
    private Integer score; // 0-10

    @JsonProperty("comment")
    private String comment;

    // Constructors
    public SkillEvaluation() {
    }

    public SkillEvaluation(String skill, Integer score, String comment) {
        this.skill = skill;
        this.score = score;
        this.comment = comment;
    }

    // Getters and Setters
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

