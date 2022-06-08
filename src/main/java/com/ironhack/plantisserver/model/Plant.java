package com.ironhack.plantisserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=3,max=20, message="Must be between 3 and 20 characters.")
    private String name;
    @Size(min=3,max=200, message="Must be between 3 and 200 characters.")
    private String notes;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "general_plant_id")
    private GeneralPlant generalPlantList;
}
