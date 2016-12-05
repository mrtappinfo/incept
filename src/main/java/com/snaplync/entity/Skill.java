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
 *  javax.persistence.ManyToMany
 *  javax.persistence.Table
 */
package com.snaplync.entity;

import com.snaplync.entity.JobSeeker;
import com.snaplync.entity.RecruiterDetails;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="R_SKILLS")
public class Skill {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="SKILL_ID", unique=true, nullable=false)
    private Long skill_id;
    @Column(name="SKILL_NAME", nullable=false)
    private String name;
    @Column(name="CREATED_DATE", nullable=false)
    private Date created;
    @Column(name="UPDATED_DATE", nullable=false)
    private Date updated;
    @ManyToMany(mappedBy="skills", fetch=FetchType.LAZY)
    private Set<JobSeeker> jobseekers = new HashSet<JobSeeker>();
    @ManyToMany(mappedBy="skills", fetch=FetchType.LAZY)
    private Set<RecruiterDetails> recruiters = new HashSet<RecruiterDetails>();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.skill_id;
    }

    public void setId(Long id) {
        this.skill_id = id;
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

    public Set<JobSeeker> getJobseekers() {
        return this.jobseekers;
    }

    public void setJobseekers(Set<JobSeeker> jobseekers) {
        this.jobseekers = jobseekers;
    }

    public Set<RecruiterDetails> getRecruiters() {
        return this.recruiters;
    }

    public void setRecruiters(Set<RecruiterDetails> recruiters) {
        this.recruiters = recruiters;
    }
}
