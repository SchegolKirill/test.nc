package com.test.nc.services;

import com.test.nc.entity.Shorter;
import com.test.nc.exception_handling.NoSuchUrlException;
import com.test.nc.repository.ShorterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class ShorterServiceImpl implements ShorterService {

    @Autowired
    private CodeGenerator codeGenerator;

    @Autowired
    private ShorterRepository shorterRepository;

    public Shorter createShortUrl(String fullUrl){
        String shortUrl = codeGenerator.generate(fullUrl.length());
        Shorter shorter = new Shorter(shortUrl, fullUrl, ZonedDateTime.now(), 0);
        return shorterRepository.save(shorter);
    }

    public List<Shorter> getAllShorters(){
        return shorterRepository.findAll();
    }

    @Override
    public void addUrl(Shorter shorter) {
        shorterRepository.save(shorter);
    }


    @Override
    public String getFullUrl(String shortUrl) {
        Shorter shorter = shorterRepository.findByShortUrl(shortUrl);
        if(shorter != null) {
            return shorter.getFullUrl();
        } else {
            throw new NoSuchUrlException("Ссылки " + shortUrl + " не существует");
        }
    }
}
