package com.ironhack.plantisserver.service.impl;

import com.ironhack.plantisserver.model.GeneralPlant;
import com.ironhack.plantisserver.repository.GeneralPlantRepository;
import com.ironhack.plantisserver.service.interfaces.GeneralPlantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class GeneralPlantService implements GeneralPlantServiceInterface {
    @Autowired
    private GeneralPlantRepository generalPlantRepository;

    public GeneralPlant findById(Long id) {
        return generalPlantRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "General plants not found"));
    }

    public void saveGeneralPlant(GeneralPlant generalPlant) {
        if (generalPlant.getId() != null) {
            Optional<GeneralPlant> optionalGeneralPlant= generalPlantRepository.findById(generalPlant.getId());
            if (optionalGeneralPlant.isPresent())
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "General plant with id " + generalPlant.getId() + " already exist");
        }
        generalPlantRepository.save(generalPlant);
    }

    public void update(Long id, GeneralPlant generalPlant) {
        GeneralPlant generalPlantFromDB = generalPlantRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "General Plant is not found"));
        generalPlant.setId(generalPlantFromDB.getId());
        generalPlantRepository.save(generalPlant);
    }

    public void deleteGeneralPlant(Long id) {
        GeneralPlant generalPlantFromDB = generalPlantRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "General Plant not found"));
        generalPlantRepository.deleteById(id);
    }
}
