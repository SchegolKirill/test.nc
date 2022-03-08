package com.test.nc.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Entity
@Table(name = "shorters")
public class Shorter {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "short_url")
    private String shortUrl;

    @Column(name = "full_url")
    private String fullUrl;

    @Column(name = "creation_date")
    private ZonedDateTime creationDate;

    @Column(name = "count_of_links")
    private Integer linksCount;

    public Shorter() {
    }

    public Shorter(String shortUrl, String fullUrl, ZonedDateTime creationDate, Integer linksCount) {
        this.shortUrl = shortUrl;
        this.fullUrl = fullUrl;
        this.creationDate = creationDate;
        this.linksCount = linksCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getLinksCount() {
        return linksCount;
    }

    public void setLinksCount(Integer linksCount) {
        this.linksCount = linksCount;
    }
}
