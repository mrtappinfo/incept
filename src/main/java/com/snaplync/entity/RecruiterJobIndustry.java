/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.Table
 */
package com.snaplync.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REC_JOB_INDUSTRY")
public class RecruiterJobIndustry {
    private static final long serialVersionUID = -1798070786993154676L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="REC_JOB_IND_ID", unique=true, nullable=false)
    private Long recJobIndustryID;
    @Column(name="REC_ID")
    private Integer recruiterID;
    @Column(name="JOB_INDUSTRY")
    private String recruiterIndustry;

    public String getRecruiterIndustry() {
        return this.recruiterIndustry;
    }

    public void setRecruiterIndustry(String recruiterIndustry3) {
        this.recruiterIndustry = recruiterIndustry3;
    }

    public Long getRecJobIndustryID() {
        return this.recJobIndustryID;
    }

    public Integer getRecruiterID() {
        return this.recruiterID;
    }

    public void setRecruiterID(Integer recruiterID) {
        this.recruiterID = recruiterID;
    }
}
