package com.ironhack.plantisserver.service.impl;


import com.ironhack.plantisserver.model.Plant;


import com.ironhack.plantisserver.model.User;
import com.ironhack.plantisserver.repository.PlantRepository;
import com.ironhack.plantisserver.repository.UserRepository;
import com.ironhack.plantisserver.service.interfaces.PlantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService implements PlantServiceInterface {



    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private UserRepository userRepository;


    public Plant findById(Long id) {
        return plantRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "plant not found"));
    }

    public List<Plant> findAll(Optional<Long> userId){
        if(userId.isPresent()){
           User userFromDB = userRepository.findById(userId.get()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
           return userFromDB.getUserFavorites();
        }
        return plantRepository.findAll();
    }


    public void savePlant(Plant plant) {
        if (plant.getId() != null) {
            Optional<Plant> optionalPlant= plantRepository.findById(plant.getId());
            if (optionalPlant.isPresent())
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Plant with id " + plant.getId() + " already exist");
        }
        plantRepository.save(plant);
    }

    public void update(Long id, Plant plant) {
        Plant plantFromDB = plantRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant is not found"));
        plant.setId(plantFromDB.getId());
        plantRepository.save(plant);
    }

    public void deletePlant(Long id) {
        Plant plantFromDB = plantRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant not found"));
        plantRepository.deleteById(id);
    }


}
