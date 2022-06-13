package com.ironhack.plantisserver.repository;

import com.ironhack.plantisserver.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

  /* @Query(value= "SELECT * FROM plant WHERE user_id = :userId", nativeQuery = true)
    List<Plant> findPlantIdByUserId(Long userId);*/
}
