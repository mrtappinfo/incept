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
@Table(name="REC_CLIENT")
public class RecruiterClient {
    private static final long serialVersionUID = -1798070786993154676L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="REC_CLIENT_ID", unique=true, nullable=false)
    private Long recruiter_client_ID;
    @Column(name="REC_ID")
    private Integer recruiter_ID;
    @Column(name="CLIENT_NAME")
    private String recruiterClientName;

    public Long getRecruiter_client_ID() {
        return this.recruiter_client_ID;
    }

    public String getRecruiterClientName() {
        return this.recruiterClientName;
    }

    public void setRecruiterClientName(String recruiterClientName) {
        this.recruiterClientName = recruiterClientName;
    }

    public Integer getRecruiter_ID() {
        return this.recruiter_ID;
    }

    public void setRecruiter_ID(Integer recruiter_ID) {
        this.recruiter_ID = recruiter_ID;
    }
}
