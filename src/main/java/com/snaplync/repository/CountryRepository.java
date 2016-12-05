/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.springframework.data.repository.PagingAndSortingRepository
 */
package com.snaplync.repository;

import com.snaplync.entity.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository
extends PagingAndSortingRepository<Country, Long> {
    public Country findByName(String var1);
}
