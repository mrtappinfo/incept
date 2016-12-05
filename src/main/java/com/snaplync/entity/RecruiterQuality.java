/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.Id
 *  javax.persistence.OneToOne
 *  javax.persistence.PrimaryKeyJoinColumn
 *  javax.persistence.Table
 */
package com.snaplync.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.snaplync.entity.Recruiter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="REC_QUALITY")
public class RecruiterQuality {
    @Id
    @Column(name="REC_ID")
    private Integer recruiterID;
    @Column(name="QUALITY")
    private Integer recruiterQuality;
    @OneToOne(fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Recruiter recruiter;

    @JsonProperty(value="recruiterQuality")
    public Integer getRecruiterQuality() {
        return this.recruiterQuality;
    }

    @JsonProperty(value="recruiterQuality")
    public void setRecruiterQuality(Integer recruiterQuality) {
        this.recruiterQuality = recruiterQuality;
    }

    public Integer getRecruiterID() {
        return this.recruiterID;
    }

    public void setRecruiterID(Integer recruiterID) {
        this.recruiterID = recruiterID;
    }

    public Recruiter getRecruiter() {
        return this.recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }
}
