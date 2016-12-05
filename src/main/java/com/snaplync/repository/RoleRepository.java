/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.springframework.data.jpa.repository.Query
 *  org.springframework.data.repository.PagingAndSortingRepository
 */
package com.snaplync.repository;

import com.snaplync.entity.Role;
import java.io.Serializable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository
extends PagingAndSortingRepository<Role, Long> {
    public static final String allRolesQuery = "select s from Role s order by s.name asc";
    public static final String findOneQuery = "Select r from Role r where r.id = ?1";

    @Query
    public Role findByName(String var1);

    @Query(value="select s from Role s order by s.name asc")
    public Iterable<Role> findAll();

    @Query(value="Select r from Role r where r.id = ?1")
    public Role findOne(Long var1);
}
