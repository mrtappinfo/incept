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
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 */
package com.snaplync.entity;

import com.snaplync.entity.State;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="R_COUNTRY")
public class Country
implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="COUNTRY_ID")
    private Long country_id;
    @Column(name="COUNTRY_NAME", nullable=false)
    private String name;
    @OneToMany(orphanRemoval=true, fetch=FetchType.EAGER, mappedBy="country")
    private Set<State> states;
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
        return this.country_id;
    }

    public void setId(Long id) {
        this.country_id = id;
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

    public Set<State> getStates() {
        return this.states;
    }

    public void setStates(Set<State> states) {
        this.states = states;
    }
}
