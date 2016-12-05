/*
 * Decompiled with CFR 0_119.
 */
package com.snaplync.dto;

import com.snaplync.dto.CityDto;
import com.snaplync.dto.IndustryDto;
import com.snaplync.dto.RoleDto;
import com.snaplync.dto.SkillDto;
import com.snaplync.dto.StateDto;
import com.snaplync.entity.Industry;
import com.snaplync.entity.JobSeeker;
import com.snaplync.entity.Role;
import com.snaplync.entity.Skill;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JobSeekerDetailedDto {
    private Long userId;
    private List<IndustryDto> industries;
    private List<RoleDto> roles;
    private List<SkillDto> skills;
    private CityDto city;
    private StateDto state;
    private Long experience;

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

    public CityDto getCity() {
        return this.city;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }

    public StateDto getState() {
        return this.state;
    }

    public void setState(StateDto state) {
        this.state = state;
    }

    public Long getExperience() {
        return this.experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public static JobSeekerDetailedDto getDto(JobSeeker jobSeeker) {
        if (jobSeeker == null) {
            return null;
        }
        JobSeekerDetailedDto dto = new JobSeekerDetailedDto();
        dto.setExperience(jobSeeker.getExperienceYear());
        ArrayList<SkillDto> skills = new ArrayList<SkillDto>();
        for (Skill skill : jobSeeker.getSkills()) {
            skills.add(SkillDto.getDto(skill));
        }
        ArrayList<IndustryDto> industries = new ArrayList<IndustryDto>();
        for (Industry industry : jobSeeker.getIndustries()) {
            industries.add(IndustryDto.getDto(industry));
        }
        ArrayList<RoleDto> roles = new ArrayList<RoleDto>();
        for (Role role : jobSeeker.getRoles()) {
            roles.add(RoleDto.getDto(role));
        }
        dto.setIndustries(industries);
        dto.setRoles(roles);
        dto.setSkills(skills);
        return dto;
    }
}
