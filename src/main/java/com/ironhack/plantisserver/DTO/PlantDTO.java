package com.ironhack.plantisserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantDTO {
    private String name;
    private String notes;
    private Long generalPlantId;
}
