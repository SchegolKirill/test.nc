package com.test.nc.repository;

import com.test.nc.entity.Shorter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShorterRepository extends JpaRepository<Shorter, Integer> {
    Shorter findByShortUrl(String shortUrl);
}
