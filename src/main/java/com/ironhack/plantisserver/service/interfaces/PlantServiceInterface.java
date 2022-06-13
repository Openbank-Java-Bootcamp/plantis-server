package com.ironhack.plantisserver.service.interfaces;

import com.ironhack.plantisserver.DTO.PlantDTO;
import com.ironhack.plantisserver.model.GeneralPlant;
import com.ironhack.plantisserver.model.Plant;

import java.util.List;

public interface PlantServiceInterface {

    void savePlant(Plant plant);
    void update(Long id, Plant plant);
    void deletePlant(Long id);


}
