package com.niral.hashmapapi.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niral.hashmapapi.Service.HashMapService;

@RestController
@RequestMapping("/api")
public class HashMapController {

	@Autowired
	private HashMapService hashMapService;

	@GetMapping("/hashmap")
	public Map<String, String> getHashMap() {
		return hashMapService.getHashMap();
	}
}
