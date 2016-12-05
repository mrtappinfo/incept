/*
 * Decompiled with CFR 0_119.
 */
package com.snaplync.dto;

import com.snaplync.dto.JobSeekerDetailedDto;
import com.snaplync.dto.RecruiterDetailedDto;
import com.snaplync.entity.JobSeeker;
import com.snaplync.entity.RecruiterDetails;
import com.snaplync.entity.User;

public class UserDto {
    private Long candidateID;
    private String email;
    private String salutation;
    private String firstName;
    private String lastName;
    private String profileURL;
    private String pic;
    private char active;
    private char isRecruiter;
    private JobSeekerDetailedDto jobseeker;
    private RecruiterDetailedDto recruiter;

    public Long getId() {
        return this.candidateID;
    }

    public void setId(Long id) {
        this.candidateID = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalutation() {
        return this.salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfileURL() {
        return this.profileURL;
    }

    public void setProfileURL(String profileURL) {
        this.profileURL = profileURL;
    }

    public String getPic() {
        return this.pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public char getActive() {
        return this.active;
    }

    public void setActive(char active) {
        this.active = active;
    }

    public char getIsRecruiter() {
        return this.isRecruiter;
    }

    public void setIsRecruiter(char isRecruiter) {
        this.isRecruiter = isRecruiter;
    }

    public JobSeekerDetailedDto getJobseeker() {
        return this.jobseeker;
    }

    public void setJobseeker(JobSeekerDetailedDto jobseeker) {
        this.jobseeker = jobseeker;
    }

    public static UserDto getDto(User user) {
        UserDto dto = new UserDto();
        dto.setActive(user.getActive());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setId(user.getId());
        dto.setIsRecruiter(user.getIsRecruiter());
        dto.setJobseeker(JobSeekerDetailedDto.getDto(user.getJobseeker()));
        dto.setRecruiter(RecruiterDetailedDto.getDto(user.getRecruiter()));
        dto.setLastName(user.getLastName());
        dto.setPic(user.getPic());
        dto.setProfileURL(user.getProfileURL());
        dto.setSalutation(user.getSalutation());
        return dto;
    }

    public RecruiterDetailedDto getRecruiter() {
        return this.recruiter;
    }

    public void setRecruiter(RecruiterDetailedDto recruiter) {
        this.recruiter = recruiter;
    }
}
