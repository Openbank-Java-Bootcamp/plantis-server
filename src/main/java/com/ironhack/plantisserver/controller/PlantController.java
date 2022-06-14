package com.ironhack.plantisserver.controller;

import com.ironhack.plantisserver.DTO.PlantDTO;
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

    @GetMapping("/generalplants/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GeneralPlant getGeneralPlantById(@PathVariable(name = "id") Long generalPlantId) {
        return generalPlantService.findById(generalPlantId);
    }

    @GetMapping("/generalplants")
    @ResponseStatus(HttpStatus.OK)
    public List<GeneralPlant> getGeneralPlant() {
        return generalPlantRepository.findAll();
    }


    /*    @PostMapping("/plant")
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

    @PostMapping("/{userId}/favorite/{plantId}")
    @ResponseStatus(HttpStatus.OK)
    User addFavoritePlantToUser(
            @PathVariable Long userId,
            @PathVariable Long plantId
    ) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User is not found"));
        GeneralPlant plant = generalPlantRepository.findById(plantId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant is not found"));
        user.userFavorites.add(plant);
        return userRepository.save(user);
    }
/*    @GetMapping("/plant/user")
    @ResponseStatus(HttpStatus.OK)
    public List<Plant> findUserPlant(Authentication authentication) {
        return plantRepository.findUserPlant(authentication);
    }*/



}

/*





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
*/
