package com.ironhack.plantisserver.controller;

import com.ironhack.plantisserver.model.GeneralPlant;
import com.ironhack.plantisserver.repository.GeneralPlantRepository;
import com.ironhack.plantisserver.service.impl.GeneralPlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GeneralPlantController {


    @Autowired
    private GeneralPlantRepository generalPlantRepository;

    @Autowired
    private GeneralPlantService generalPlantService;

    @GetMapping("/generalplant/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GeneralPlant getGeneralPlantById(@PathVariable(name = "id") Long generalPlantId) {
        return generalPlantService.findById(generalPlantId);
    }

    @GetMapping("/generalplant")
    @ResponseStatus(HttpStatus.OK)
    public List<GeneralPlant> getGeneralPlant() {
        return generalPlantRepository.findAll();
    }

    @PostMapping("/generalplant")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGeneralPlant(@RequestBody @Valid GeneralPlant generalPlant){
        generalPlantService.saveGeneralPlant(generalPlant);
    }

    @PutMapping("/generalplant/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGeneralPlant(@PathVariable Long id,@RequestBody @Valid GeneralPlant generalPlant){
        generalPlantService.update(id, generalPlant);
    }

    @DeleteMapping("/generalplant/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGeneralPlant(@PathVariable Long id){
        generalPlantService.deleteGeneralPlant(id);
    }


}
