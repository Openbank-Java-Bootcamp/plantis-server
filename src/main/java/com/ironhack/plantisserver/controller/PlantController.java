package com.ironhack.plantisserver.controller;

import com.ironhack.plantisserver.DTO.PlantDTO;
import com.ironhack.plantisserver.model.GeneralPlant;
import com.ironhack.plantisserver.model.Plant;
import com.ironhack.plantisserver.repository.GeneralPlantRepository;
import com.ironhack.plantisserver.repository.PlantRepository;
import com.ironhack.plantisserver.service.impl.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @Autowired
    private PlantRepository plantRepository;

 /*   @PostMapping("/plant")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePlant(@RequestBody PlantDTO plant){
        plantService.savePlant(plant);
    }*/
    @GetMapping("/plant/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Plant getPlantById(@PathVariable(name = "id") Long plantId) {
        return plantService.findById(plantId);
    }

    @GetMapping("/plant")
    @ResponseStatus(HttpStatus.OK)
    public List<Plant> getPlant() {
        return plantRepository.findAll();
    }

    @PostMapping("/plant")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlant(@RequestBody @Valid Plant plant){
        plantService.savePlant(plant);
    }

    @PutMapping("/plant/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePlant(@PathVariable Long id,@RequestBody @Valid Plant plant){
        plantService.update(id, plant);
    }

    @DeleteMapping("/generalplant/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlant(@PathVariable Long id){
        plantService.deletePlant(id);
    }

}
