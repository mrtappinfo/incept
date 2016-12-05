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
import java.io.Serializable;
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
@Table(name="RECRUITER_CLNT")
public class RecruiterDetails
implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="RECRUITER_ID", unique=true, nullable=false)
    private Long recruiter_id;
    @Column(name="MIN_COMP_HLY", nullable=true)
    private long minCompensationHourly;
    @Column(name="MAX_COMP_HLY", nullable=true)
    private long maxCompensationHourly;
    @Column(name="MIN_COMP_MONTHLY", nullable=true)
    private long minCompensationMonthly;
    @Column(name="MAX_COMP_MONTHLY", nullable=true)
    private long maxCompensationMonthly;
    @Column(name="MIN_COMP_YEARLY", nullable=true)
    private long minCompensationYearly;
    @Column(name="MAX_COMP_YEARLY", nullable=true)
    private long maxCompensationYearly;
    @Column(name="CREATED_DATE", nullable=false)
    private Date createdDate;
    @Column(name="UPDATED_DATE", nullable=false)
    private Date updatedDate;
    @ManyToOne
    @JoinColumn(name="CURRENCY_ID", referencedColumnName="currency_id", nullable=false)
    private Currency currency;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="RECRUITER_ROLE", joinColumns={@JoinColumn(name="recruiter_id")}, inverseJoinColumns={@JoinColumn(name="role_id")})
    private Set<Role> roles = new HashSet<Role>();
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="RECRUITER_SKILLS", joinColumns={@JoinColumn(name="recruiter_id")}, inverseJoinColumns={@JoinColumn(name="skill_id")})
    private Set<Skill> skills = new HashSet<Skill>();
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="RECRUITER_INDUSTRY", joinColumns={@JoinColumn(name="recruiter_id")}, inverseJoinColumns={@JoinColumn(name="ind_id")})
    private Set<Industry> industries = new HashSet<Industry>();
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="RECRUITER_CITY", joinColumns={@JoinColumn(name="recruiter_id")}, inverseJoinColumns={@JoinColumn(name="city_id")})
    private Set<City> cities = new HashSet<City>();
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="RECRUITER_STATE", joinColumns={@JoinColumn(name="recruiter_id")}, inverseJoinColumns={@JoinColumn(name="state_id")})
    private Set<State> states = new HashSet<State>();

    public Long getId() {
        return this.recruiter_id;
    }

    public void setId(Long id) {
        this.recruiter_id = id;
    }

    public long getMinCompensationHourly() {
        return this.minCompensationHourly;
    }

    public void setMinCompensationHourly(long minCompensationHourly) {
        this.minCompensationHourly = minCompensationHourly;
    }

    public long getMaxCompensationHourly() {
        return this.maxCompensationHourly;
    }

    public void setMaxCompensationHourly(long maxCompensationHourly) {
        this.maxCompensationHourly = maxCompensationHourly;
    }

    public long getMinCompensationMonthly() {
        return this.minCompensationMonthly;
    }

    public void setMinCompensationMonthly(long minCompensationMonthly) {
        this.minCompensationMonthly = minCompensationMonthly;
    }

    public long getMaxCompensationMonthly() {
        return this.maxCompensationMonthly;
    }

    public void setMaxCompensationMonthly(long maxCompensationMonthly) {
        this.maxCompensationMonthly = maxCompensationMonthly;
    }

    public long getMinCompensationYearly() {
        return this.minCompensationYearly;
    }

    public void setMinCompensationYearly(long minCompensationYearly) {
        this.minCompensationYearly = minCompensationYearly;
    }

    public long getMaxCompensationYearly() {
        return this.maxCompensationYearly;
    }

    public void setMaxCompensationYearly(long maxCompensationYearly) {
        this.maxCompensationYearly = maxCompensationYearly;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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

    public Set<City> getCities() {
        return this.cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public Set<State> getStates() {
        return this.states;
    }

    public void setStates(Set<State> states) {
        this.states = states;
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
