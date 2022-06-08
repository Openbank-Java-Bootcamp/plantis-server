package com.ironhack.plantisserver.repository;

import com.ironhack.plantisserver.model.GeneralPlant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralPlantRepository extends JpaRepository<GeneralPlant, Long> {

}
