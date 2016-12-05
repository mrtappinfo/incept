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
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 */
package com.snaplync.entity;

import com.snaplync.entity.City;
import com.snaplync.entity.Country;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="R_STATE")
public class State
implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="STATE_ID", nullable=false)
    private Long state_id;
    @Column(name="STATE_NAME", nullable=false)
    private String name;
    @Column(name="STATE_CODE", nullable=false)
    private String code;
    @ManyToOne
    @JoinColumn(name="country_id", referencedColumnName="country_id", nullable=false)
    private Country country;
    @OneToMany(orphanRemoval=true, fetch=FetchType.EAGER, mappedBy="state")
    private Set<City> cities;
    @Column(name="CREATED_DATE", nullable=false)
    private Date created;
    @Column(name="UPDATED_DATE", nullable=false)
    private Date updated;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.state_id;
    }

    public void setId(Long id) {
        this.state_id = id;
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

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<City> getCities() {
        return this.cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
