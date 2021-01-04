package com.itlize.microservice.auth.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtTokenBlacklistService {
    
    private static Set<String> blacklist = new HashSet<>();
     
    public void add(String input) {
        blacklist.add(input);
    }

    public boolean check(String input) {
        return !blacklist.contains(input);
    }
}
