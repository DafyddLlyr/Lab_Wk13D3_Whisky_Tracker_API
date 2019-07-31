package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "region/{region}")
    public List<Distillery> getDistilleriesByRegion(@PathVariable String region) {
        return distilleryRepository.findDistilleryByRegion(region.toLowerCase());
    }

    @GetMapping(value = "{id}/age/{age}")
    public List<Whisky> getWhiskiesByDistilleryAndAge(@PathVariable Long id, @PathVariable int age) {
        return whiskyRepository.findWhiskeyByDistilleryIdAndAge(id, age);
    }
}
