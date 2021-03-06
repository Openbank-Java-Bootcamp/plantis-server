package com.ironhack.plantisserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralPlant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Provide a url image.")
    @Lob
    private String image;
    @NotNull
    @Size(min=1,max=40, message="Must be between 3 and 20 characters.")
    private String name;
    @NotEmpty(message = "Provide a description.")
    private String description;
    @NotEmpty(message = "Provide a preference of light.")
    private String lightRequirement;
    @NotEmpty(message = "Provide a water quantity.")
    private String waterRequirement;

    @JsonIgnore
    @ManyToMany(mappedBy = "userFavorites")
    private List<User> users;

    public GeneralPlant(String image, String name, String description, String lightRequirement, String waterRequirement) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.lightRequirement = lightRequirement;
        this.waterRequirement = waterRequirement;
    }
}
