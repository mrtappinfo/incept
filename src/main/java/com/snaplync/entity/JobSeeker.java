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
 *  javax.persistence.JoinTable
 *  javax.persistence.ManyToMany
 *  javax.persistence.ManyToOne
 *  javax.persistence.Table
 */
package com.snaplync.entity;

import com.snaplync.entity.City;
import com.snaplync.entity.Currency;
import com.snaplync.entity.Industry;
import com.snaplync.entity.Role;
import com.snaplync.entity.Skill;
import com.snaplync.entity.State;
import com.snaplync.entity.TimeUnit;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="JOBSEEKER")
public class JobSeeker
implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private Long jobseeker_id;
    @Column(name="COMPENSATION", nullable=false)
    private long compensation;
    @Column(name="HIKE", nullable=false)
    private BigDecimal hike;
    @ManyToOne
    @JoinColumn(name="time_unit_id", referencedColumnName="timeunit_id", nullable=false)
    private TimeUnit timeUnit;
    @Column(name="EXPERIENCE_YEAR")
    private Long experienceYear;
    @Column(name="EXPERIENCE_MONTH")
    private Long experienceMonth;
    @Column(name="CREATED_DATE", nullable=false)
    private Date createdDate;
    @Column(name="UPDATED_DATE", nullable=false)
    private Date updatedDate;
    @ManyToOne
    @JoinColumn(name="CURRENCY_ID", referencedColumnName="currency_id", nullable=false)
    private Currency currency;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="JOBSEEKER_ROLE", joinColumns={@JoinColumn(name="jobseeker_id")}, inverseJoinColumns={@JoinColumn(name="role_id")})
    private Set<Role> roles = new HashSet<Role>();
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="JOBSEEKER_SKILLS", joinColumns={@JoinColumn(name="jobseeker_id")}, inverseJoinColumns={@JoinColumn(name="skill_id")})
    private Set<Skill> skills = new HashSet<Skill>();
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="JOBSEEKER_INDUSTRY", joinColumns={@JoinColumn(name="jobseeker_id")}, inverseJoinColumns={@JoinColumn(name="ind_id")})
    private Set<Industry> industries = new HashSet<Industry>();
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="JOBSEEKER_CITY", joinColumns={@JoinColumn(name="jobseeker_id")}, inverseJoinColumns={@JoinColumn(name="city_id")})
    private Set<City> cities = new HashSet<City>();
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="JOBSEEKER_STATE", joinColumns={@JoinColumn(name="jobseeker_id")}, inverseJoinColumns={@JoinColumn(name="state_id")})
    private Set<State> states = new HashSet<State>();

    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Set<City> getCities() {
        return this.cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public Long getId() {
        return this.jobseeker_id;
    }

    public void setId(Long id) {
        this.jobseeker_id = id;
    }

    public long getCompensation() {
        return this.compensation;
    }

    public void setCompensation(long compensation) {
        this.compensation = compensation;
    }

    public BigDecimal getHike() {
        return this.hike;
    }

    public void setHike(BigDecimal hike) {
        this.hike = hike;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Skill> getSkills() {
        return this.skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Industry> getIndustries() {
        return this.industries;
    }

    public void setIndustries(Set<Industry> industries) {
        this.industries = industries;
    }

    public TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public Long getExperienceYear() {
        return this.experienceYear;
    }

    public void setExperienceYear(Long experienceYear) {
        this.experienceYear = experienceYear;
    }

    public Long getExperienceMonth() {
        return this.experienceMonth;
    }

    public void setExperienceMonth(Long experienceMonth) {
        this.experienceMonth = experienceMonth;
    }

    public void setState(Set<State> state) {
        this.states = state;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
