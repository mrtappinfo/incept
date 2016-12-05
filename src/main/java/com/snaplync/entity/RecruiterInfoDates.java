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
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="REC_INFO_DATES")
public class RecruiterInfoDates {
    @Id
    @Column(name="REC_ID")
    private Integer recruiterID;
    @Column(name="INFO_START_DATE")
    private Date infoStartDate;
    @Column(name="INFO_END_DATE")
    private Date infoEndDate;
    @OneToOne(fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Recruiter recruiter;

    public Integer getRecruiterID() {
        return this.recruiterID;
    }

    public void setRecruiterID(Integer recruiterID) {
        this.recruiterID = recruiterID;
    }

    public Date getInfoStartDate() {
        return this.infoStartDate;
    }

    public void setInfoStartDate(Date infoStartDate) {
        this.infoStartDate = infoStartDate;
    }

    public Date getInfoEndDate() {
        return this.infoEndDate;
    }

    public void setInfoEndDate(Date infoEndDate) {
        this.infoEndDate = infoEndDate;
    }

    public Recruiter getRecruiter() {
        return this.recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }
}
