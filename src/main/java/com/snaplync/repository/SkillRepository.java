/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.springframework.data.domain.Pageable
 *  org.springframework.data.jpa.repository.Query
 *  org.springframework.data.repository.PagingAndSortingRepository
 *  org.springframework.data.repository.query.Param
 */
package com.snaplync.repository;

import com.snaplync.entity.Skill;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface SkillRepository
extends PagingAndSortingRepository<Skill, Long> {
    public static final String likeQuery = "select s from Skill s where LOWER(s.name) like CONCAT('%',:name,'%') order by s.name asc";
    public static final String allSkillsQuery = "select s from Skill s order by s.name asc";
    public static final String findOneQuery = "Select s from Skill s where s.id = ?1";

    public Skill findByName(String var1);

    @Query(value="select s from Skill s where LOWER(s.name) like CONCAT('%',:name,'%') order by s.name asc")
    public List<Skill> findSkillLike(@Param(value="name") String var1, Pageable var2);

    @Query(value="select s from Skill s order by s.name asc")
    public Iterable<Skill> findAll();

    @Query(value="Select s from Skill s where s.id = ?1")
    public Skill findOne(Long var1);
}
