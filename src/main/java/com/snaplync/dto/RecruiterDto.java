/*
 * Decompiled with CFR 0_119.
 */
package com.snaplync.dto;

import java.io.Serializable;
import java.util.List;

public class RecruiterDto
implements Serializable {
    private Long userId;
    private List<Long> industries;
    private List<Long> roles;
    private List<Long> skills;
    private List<Long> states;
    private List<Long> cities;
    private Long maxCompensationYearly;
    private Long minCompensationYearly;
    private Long maxCompensationMonthly;
    private Long minCompensationMonthly;
    private Long maxCompensationHourly;
    private Long minCompensationHourly;

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

    public List<Long> getStates() {
        return this.states;
    }

    public void setStates(List<Long> states) {
        this.states = states;
    }

    public List<Long> getCities() {
        return this.cities;
    }

    public void setCities(List<Long> cities) {
        this.cities = cities;
    }

    public Long getMaxCompensationYearly() {
        return this.maxCompensationYearly;
    }

    public void setMaxCompensationYearly(Long maxCompensationYearly) {
        this.maxCompensationYearly = maxCompensationYearly;
    }

    public Long getMinCompensationYearly() {
        return this.minCompensationYearly;
    }

    public void setMinCompensationYearly(Long minCompensationYearly) {
        this.minCompensationYearly = minCompensationYearly;
    }

    public Long getMaxCompensationMonthly() {
        return this.maxCompensationMonthly;
    }

    public void setMaxCompensationMonthly(Long maxCompensationMonthly) {
        this.maxCompensationMonthly = maxCompensationMonthly;
    }

    public Long getMinCompensationMonthly() {
        return this.minCompensationMonthly;
    }

    public void setMinCompensationMonthly(Long minCompensationMonthly) {
        this.minCompensationMonthly = minCompensationMonthly;
    }

    public Long getMaxCompensationHourly() {
        return this.maxCompensationHourly;
    }

    public void setMaxCompensationHourly(Long maxCompensationHourly) {
        this.maxCompensationHourly = maxCompensationHourly;
    }

    public Long getMinCompensationHourly() {
        return this.minCompensationHourly;
    }

    public void setMinCompensationHourly(Long minCompensationHourly) {
        this.minCompensationHourly = minCompensationHourly;
    }
}
