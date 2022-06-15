package com.ironhack.plantisserver.controller;

import com.ironhack.plantisserver.DTO.PlantDTO;
import com.ironhack.plantisserver.DTO.PlantNoteDTO;
import com.ironhack.plantisserver.model.GeneralPlant;
import com.ironhack.plantisserver.model.Plant;
import com.ironhack.plantisserver.model.User;
import com.ironhack.plantisserver.repository.GeneralPlantRepository;
import com.ironhack.plantisserver.repository.PlantRepository;
import com.ironhack.plantisserver.repository.UserRepository;
import com.ironhack.plantisserver.service.impl.GeneralPlantService;
import com.ironhack.plantisserver.service.impl.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GeneralPlantRepository generalPlantRepository;

    @Autowired
    private GeneralPlantService generalPlantService;


    @GetMapping("/plants/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Plant getPlantById(@PathVariable(name = "id") Long plantId) {
        return plantService.findById(plantId);
    }

    @GetMapping("/plants")
    @ResponseStatus(HttpStatus.OK)
    public List<Plant> getPlants(@RequestParam Optional<Long> userId) {
        return plantService.findAll(userId);
    }

    @GetMapping("/plants/favourite/{plantId}")
    @ResponseStatus(HttpStatus.OK)
    public User addFavoritePlantToUser(@PathVariable Long plantId, Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        User userFromDb = userRepository.findByEmail(email);
        GeneralPlant plant = generalPlantRepository.findById(plantId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant is not found"));
        Plant newUserPlant = new Plant(plant.getName(),plant.getImage(),plant.getDescription(),plant.getLightRequirement(),plant.getWaterRequirement());
        userFromDb.userFavorites.add(newUserPlant);
        return userRepository.save(userFromDb);
    }


    @DeleteMapping("/favourite/{plantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlant(@PathVariable Long plantId,Authentication authentication){
        plantService.deletePlant(plantId,authentication);
    }

    @PutMapping("/favourite/{plantid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePlant(@PathVariable Long plantid,@RequestBody @Valid Plant plant){
        plantService.update(plantid, plant);
    }

    @PatchMapping("/favourite/{plantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateNotes(@PathVariable Long plantId, @RequestBody PlantNoteDTO note){
        System.out.println(plantId);
        System.out.println(note);
        plantService.updateNotes(plantId, note.getNote());
    }





}


