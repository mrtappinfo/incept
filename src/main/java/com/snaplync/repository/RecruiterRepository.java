/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.springframework.data.repository.PagingAndSortingRepository
 */
package com.snaplync.repository;

import com.snaplync.entity.RecruiterDetails;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RecruiterRepository
extends PagingAndSortingRepository<RecruiterDetails, Long> {
}
