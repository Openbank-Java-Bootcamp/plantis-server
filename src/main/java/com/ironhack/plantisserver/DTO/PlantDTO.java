package com.ironhack.plantisserver.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.plantisserver.enums.Light;
import com.ironhack.plantisserver.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantDTO {
    private String image;
    private String description;
    private Light lightPreference;
    private String waterRequirement;
    private String notes;
    private Long userId;
}
