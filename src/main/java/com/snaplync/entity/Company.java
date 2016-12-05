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
@Table(name="COMPANY")
public class Company {
    @Id
    @Column(name="CMP_ID")
    private Integer companyID;
    @Column(name="CMP_NAME")
    private String recruiterCompanyName;
    @OneToOne(fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Recruiter recruiter;

    public Integer getCompanyID() {
        return this.companyID;
    }

    public void setCompanyID(Integer recruiterCompanyID) {
        this.companyID = recruiterCompanyID;
    }

    public String getRecruiterCompanyName() {
        return this.recruiterCompanyName;
    }

    public void setRecruiterCompanyName(String recruiterCompanyName) {
        this.recruiterCompanyName = recruiterCompanyName;
    }

    public Recruiter getRecruiter() {
        return this.recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }
}
