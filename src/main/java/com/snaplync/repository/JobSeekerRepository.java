/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.springframework.data.repository.PagingAndSortingRepository
 */
package com.snaplync.repository;

import com.snaplync.entity.JobSeeker;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobSeekerRepository
extends PagingAndSortingRepository<JobSeeker, Long> {
}
