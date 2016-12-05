/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.springframework.data.repository.PagingAndSortingRepository
 *  org.springframework.stereotype.Repository
 */
package com.snaplync.repository;

import com.snaplync.entity.Recruiter;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterActionsRepository
extends PagingAndSortingRepository<Recruiter, Long> {
}
