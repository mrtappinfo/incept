/*
 * Decompiled with CFR 0_119.
 */
package com.snaplync.dto;

import java.util.List;

public class JobSeekerDto {
    private Long userId;
    private List<Long> industries;
    private List<Long> roles;
    private List<Long> skills;
    private List<Long> city;
    private List<Long> state;
    private Long experience;

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getIndustries() {
        return this.industries;
    }

    public void setIndustries(List<Long> industries) {
        this.industries = industries;
    }

    public List<Long> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }

    public List<Long> getSkills() {
        return this.skills;
    }

    public void setSkills(List<Long> skills) {
        this.skills = skills;
    }

    public List<Long> getCity() {
        return this.city;
    }

    public void setCity(List<Long> city) {
        this.city = city;
    }

    public Long getExperience() {
        return this.experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public List<Long> getState() {
        return this.state;
    }

    public void setState(List<Long> state) {
        this.state = state;
    }
}
