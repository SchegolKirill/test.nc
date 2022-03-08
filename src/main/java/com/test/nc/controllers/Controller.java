package com.test.nc.controllers;

import com.test.nc.entity.Shorter;
import com.test.nc.services.CodeGenerator;
import com.test.nc.services.ShorterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/short")
public class Controller {

    @Autowired
    private ShorterService shorterService;

    @Autowired
    private CodeGenerator codeGenerator;

    @PostMapping("/create")
    public Shorter createShortUrl(@RequestParam (name = "url") String fullUrl) {
        return shorterService.createShortUrl(fullUrl);
    }

    @GetMapping("/getall")
    public List<Shorter> getAll() {
        return shorterService.getAllShorters();
    }

    @GetMapping(path = "/redirect/{short_url}")
    public ResponseEntity redirectShorter(@PathVariable(name = "short_url") String shortUrl) {
        //TODO find hash in DB and redirect to original URL
        String fullUrl = shorterService.getFullUrl(shortUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", fullUrl);
        return new ResponseEntity<String>(headers, HttpStatus.FOUND);
    }

    @PostMapping("/addurl")
    public Shorter addNewUrl(@RequestBody Shorter shorter) {
        shorterService.addUrl(shorter);
        return shorter;
    }

    @GetMapping("/{shorturl}")
    public String getShortUrl (@PathVariable (name = "shorturl") String shortUrl) {
        return shorterService.getFullUrl(shortUrl);
    }
}
