/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.Table
 */
package com.snaplync.entity;

import com.snaplync.entity.User;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="R_SESSION")
public class Session
implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="SESSION_ID", nullable=false)
    private Long session_id;
    @Column(name="TOKEN", nullable=false)
    private String token;
    @Column(name="ACTIVE", nullable=false)
    private char active;
    @Column(name="CREATED_DATE", nullable=false)
    private Date createdTime;
    @Column(name="UPDATED_DATE", nullable=false)
    Date lastRequestTime;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="can_id", nullable=true)
    User user;

    public Long getId() {
        return this.session_id;
    }

    public void setId(Long id) {
        this.session_id = id;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public char getActive() {
        return this.active;
    }

    public void setActive(char active) {
        this.active = active;
    }

    public Date getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastRequestTime() {
        return this.lastRequestTime;
    }

    public void setLastRequestTime(Date lastRequestTime) {
        this.lastRequestTime = lastRequestTime;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
