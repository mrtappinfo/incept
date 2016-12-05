/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 */
package com.snaplync.entity;

import com.snaplync.entity.JobSeeker;
import com.snaplync.entity.RecruiterDetails;
import com.snaplync.entity.Session;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CANDIDATE")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="CAN_ID", unique=true, nullable=false)
    private Long can_id;
    @Column(name="PHONE_NO")
    private String phoneNumber;
    @Column(name="EMAIL")
    private String email;
    @Column(name="SALUTATION")
    private String salutation;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="PROFILE_URL")
    private String profileURL;
    @Column(name="PIC")
    private String pic;
    @Column(name="IS_ACTIVE")
    private char active;
    @Column(name="IS_RECRUITER")
    private char isRecruiter;
    @Column(name="STATE")
    private String state;
    @Column(name="CITY")
    private String city;
    @Column(name="ZIP")
    private String zip;
    @Column(name="COUNTRY")
    private String country;
    @ManyToOne
    @JoinColumn(name="jobseeker_id", referencedColumnName="id", nullable=true)
    JobSeeker jobseeker;
    @ManyToOne
    @JoinColumn(name="recruiter_id", referencedColumnName="recruiter_id", nullable=true)
    RecruiterDetails recruiter;
    @OneToMany(orphanRemoval=true, fetch=FetchType.LAZY, mappedBy="user")
    private List<Session> sessions;
    @Column(name="CREATED_DATE")
    private Date created;
    @Column(name="UPDATED_DATE")
    private Date updated;

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

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return this.updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public char getIsRecruiter() {
        return this.isRecruiter;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setIsRecruiter(char isRecruiter) {
        this.isRecruiter = isRecruiter;
    }

    public Long getId() {
        return this.can_id;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public JobSeeker getJobseeker() {
        return this.jobseeker;
    }

    public void setJobseeker(JobSeeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    public RecruiterDetails getRecruiter() {
        return this.recruiter;
    }

    public void setRecruiter(RecruiterDetails recruiter) {
        this.recruiter = recruiter;
    }

    public List<Session> getSessions() {
        return this.sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
