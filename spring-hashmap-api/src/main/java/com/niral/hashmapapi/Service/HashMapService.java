package com.niral.hashmapapi.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class HashMapService {

    public Map<String, String> getHashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Hello, World!");
        map.put("status", "success");
        return map;
    }
}
