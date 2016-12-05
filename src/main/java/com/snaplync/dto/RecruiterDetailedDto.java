/*
 * Decompiled with CFR 0_119.
 */
package com.snaplync.dto;

import com.snaplync.dto.CityDto;
import com.snaplync.dto.IndustryDto;
import com.snaplync.dto.RoleDto;
import com.snaplync.dto.SkillDto;
import com.snaplync.dto.StateDto;
import com.snaplync.entity.City;
import com.snaplync.entity.Industry;
import com.snaplync.entity.RecruiterDetails;
import com.snaplync.entity.Role;
import com.snaplync.entity.Skill;
import com.snaplync.entity.State;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RecruiterDetailedDto {
    private Long userId;
    private List<IndustryDto> industries;
    private List<RoleDto> roles;
    private List<SkillDto> skills;
    private List<StateDto> states;
    private List<CityDto> cities;
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

    public List<IndustryDto> getIndustries() {
        return this.industries;
    }

    public void setIndustries(List<IndustryDto> industries) {
        this.industries = industries;
    }

    public List<RoleDto> getRoles() {
        return this.roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public List<SkillDto> getSkills() {
        return this.skills;
    }

    public void setSkills(List<SkillDto> skills) {
        this.skills = skills;
    }

    public List<StateDto> getStates() {
        return this.states;
    }

    public void setStates(List<StateDto> states) {
        this.states = states;
    }

    public List<CityDto> getCities() {
        return this.cities;
    }

    public void setCities(List<CityDto> cities) {
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

    public static RecruiterDetailedDto getDto(RecruiterDetails recruiter) {
        if (recruiter == null) {
            return null;
        }
        RecruiterDetailedDto dto = new RecruiterDetailedDto();
        dto.setMaxCompensationHourly(recruiter.getMaxCompensationHourly());
        dto.setMinCompensationHourly(recruiter.getMinCompensationHourly());
        dto.setMaxCompensationMonthly(recruiter.getMaxCompensationMonthly());
        dto.setMinCompensationMonthly(recruiter.getMinCompensationMonthly());
        dto.setMaxCompensationYearly(recruiter.getMaxCompensationYearly());
        dto.setMinCompensationYearly(recruiter.getMinCompensationYearly());
        ArrayList<SkillDto> skills = new ArrayList<SkillDto>();
        for (Skill skill : recruiter.getSkills()) {
            skills.add(SkillDto.getDto(skill));
        }
        ArrayList<IndustryDto> industries = new ArrayList<IndustryDto>();
        for (Industry industry : recruiter.getIndustries()) {
            industries.add(IndustryDto.getDto(industry));
        }
        ArrayList<RoleDto> roles = new ArrayList<RoleDto>();
        for (Role role : recruiter.getRoles()) {
            roles.add(RoleDto.getDto(role));
        }
        ArrayList<CityDto> cities = new ArrayList<CityDto>();
        for (City city : recruiter.getCities()) {
            cities.add(CityDto.getDto(city));
        }
        ArrayList<StateDto> states = new ArrayList<StateDto>();
        for (State state : recruiter.getStates()) {
            states.add(StateDto.getDto(state));
        }
        dto.setIndustries(industries);
        dto.setRoles(roles);
        dto.setSkills(skills);
        dto.setStates(states);
        dto.setCities(cities);
        return dto;
    }
}
