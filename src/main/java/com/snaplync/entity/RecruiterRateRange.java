/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.Id
 *  javax.persistence.OneToOne
 *  javax.persistence.PrimaryKeyJoinColumn
 *  javax.persistence.Table
 */
package com.snaplync.entity;

import com.snaplync.entity.Recruiter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="REC_RATE_RANGE")
public class RecruiterRateRange {
    @Id
    @Column(name="REC_ID")
    private Integer recruiterID;
    @Column(name="REC_RATE_MIN")
    private Integer recruiterRateMin;
    @Column(name="REC_RATE_MAX")
    private Integer recruiterRateMax;
    @Column(name="CURRENCY")
    private String currency;
    @OneToOne(fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Recruiter recruiter;

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getRecruiterRateMin() {
        return this.recruiterRateMin;
    }

    public void setRecruiterRateMin(Integer recruiterRateMin) {
        this.recruiterRateMin = recruiterRateMin;
    }

    public Integer getRecruiterRateMax() {
        return this.recruiterRateMax;
    }

    public void setRecruiterRateMax(Integer recruiterRateMax) {
        this.recruiterRateMax = recruiterRateMax;
    }

    public Recruiter getRecruiter() {
        return this.recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public Integer getRecruiterID() {
        return this.recruiterID;
    }

    public void setRecruiterID(Integer recruiterID) {
        this.recruiterID = recruiterID;
    }
}
