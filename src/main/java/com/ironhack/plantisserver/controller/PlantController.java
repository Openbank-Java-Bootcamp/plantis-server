package com.ironhack.plantisserver.controller;

import com.ironhack.plantisserver.DTO.PlantDTO;
import com.ironhack.plantisserver.service.impl.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @PostMapping("/plant")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePlant(@RequestBody PlantDTO plant){
        plantService.savePlant(plant);
    }

}
