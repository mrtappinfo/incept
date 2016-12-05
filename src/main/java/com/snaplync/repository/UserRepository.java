/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.springframework.data.jpa.repository.Query
 *  org.springframework.data.repository.PagingAndSortingRepository
 */
package com.snaplync.repository;

import com.snaplync.entity.User;
import java.io.Serializable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository
extends PagingAndSortingRepository<User, Long> {
    public static final String findOneQuery = "Select u from User u where u.can_id = ?1";

    public User findByEmail(String var1);

    @Query(value="Select u from User u where u.can_id = ?1")
    public User findOne(Long var1);
}
