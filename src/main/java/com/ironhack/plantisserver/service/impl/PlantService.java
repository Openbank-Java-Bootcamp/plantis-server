package com.ironhack.plantisserver.service.impl;

import com.ironhack.plantisserver.DTO.PlantDTO;
import com.ironhack.plantisserver.model.Plant;
import com.ironhack.plantisserver.repository.GeneralPlantRepository;
import com.ironhack.plantisserver.repository.PlantRepository;
import com.ironhack.plantisserver.service.interfaces.PlantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantService implements PlantServiceInterface {

    @Autowired
    private GeneralPlantRepository generalPlantRepository;

    @Autowired
    private PlantRepository plantRepository;

    public void savePlant(PlantDTO plant){
        Plant newPlant = new Plant();
        newPlant.setName(plant.getName());
        newPlant.setNotes(plant.getNotes());
        newPlant.setGeneralPlantList(generalPlantRepository.findById(plant.getGeneralPlantId()).get());
        plantRepository.save(newPlant);
    }
}
