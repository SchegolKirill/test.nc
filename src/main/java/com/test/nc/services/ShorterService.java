package com.test.nc.services;

import com.test.nc.entity.Shorter;

import java.util.List;

public interface ShorterService {
    Shorter createShortUrl(String url);
    String getFullUrl(String shortUrl);
    List<Shorter> getAllShorters();
    void addUrl(Shorter shorter);
}
