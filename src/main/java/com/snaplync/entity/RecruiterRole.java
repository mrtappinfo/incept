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
@Table(name="REC_ROLE")
public class RecruiterRole {
    private static final long serialVersionUID = -1798070786993154676L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="REC_ROLE_ID")
    private Long recruiterRoleID;
    @Column(name="DESIRED_ROLL")
    private String recruiterDesiredRole;
    @Column(name="DESIRED_ROLL_EXP")
    private Integer recruiterRoleExp;
    @Column(name="REC_ID")
    private Integer recruiterID;

    public Long getRecruiterRoleID() {
        return this.recruiterRoleID;
    }

    public String getRecruiterDesiredRole() {
        return this.recruiterDesiredRole;
    }

    public void setRecruiterDesiredRole(String recruiterDesiredRole) {
        this.recruiterDesiredRole = recruiterDesiredRole;
    }

    public Integer getRecruiterRoleExp() {
        return this.recruiterRoleExp;
    }

    public void setRecruiterRoleExp(Integer recruiterRoleExp) {
        this.recruiterRoleExp = recruiterRoleExp;
    }

    public Integer getRecruiterID() {
        return this.recruiterID;
    }

    public void setRecruiterID(Integer recruiterID) {
        this.recruiterID = recruiterID;
    }
}
