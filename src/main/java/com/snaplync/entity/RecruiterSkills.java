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
@Table(name="REC_SKILL")
public class RecruiterSkills {
    private static final long serialVersionUID = -1798070786993154676L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="REC_SKILL_ID")
    private Long recruiterSkillID;
    @Column(name="REC_ID")
    private Integer recruiterID;
    @Column(name="DESIRED_SKILL")
    private String recruiterSkill;
    @Column(name="DESIRED_SKILL_EXP")
    private Integer recruiterSkillExp;

    public String getRecruiterSkill() {
        return this.recruiterSkill;
    }

    public void setRecruiterSkill(String recruiterSkill) {
        this.recruiterSkill = recruiterSkill;
    }

    public Integer getRecruiterID() {
        return this.recruiterID;
    }

    public void setRecruiterID(Integer recruiterID) {
        this.recruiterID = recruiterID;
    }

    public Long getRecruiterSkillID() {
        return this.recruiterSkillID;
    }

    public Integer getRecruiterSkillExp() {
        return this.recruiterSkillExp;
    }

    public void setRecruiterSkillExp(Integer recruiterSkillExp) {
        this.recruiterSkillExp = recruiterSkillExp;
    }
}
