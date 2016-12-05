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

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="R_TIMEUNIT")
public class TimeUnit
implements Serializable {
    public static final String yearly = "YEARLY";
    public static final String monthly = "MONTHLY";
    public static final String hourly = "HOURLY";
    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="TIMEUNIT_ID")
    private Long timeunit_id;
    @Column(name="TIMEUNIT_NAME", nullable=false, unique=true)
    private String name;
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
        return this.timeunit_id;
    }

    public void setId(Long id) {
        this.timeunit_id = id;
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
}
