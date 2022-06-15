package com.ironhack.plantisserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.plantisserver.enums.Light;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=3,max=20, message="Must be between 3 and 20 characters.")
    private String name;
    @NotEmpty(message = "Provide a url image.")
    private String image;
    @NotEmpty(message = "Provide a description.")
    private String description;
    @NotEmpty(message = "Provide a preference of light.")
    private String lightPreference;
    @NotEmpty(message = "Provide a water quantity.")
    private String waterRequirement;
    @Size(min=3,max=200, message="Must be between 3 and 200 characters.")
    private String notes;

    @JsonIgnore
    @ManyToMany(mappedBy = "userFavorites")
    private List<User> users;

    public Plant(String name, String image, String description, String lightPreference, String waterRequirement) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.lightPreference = lightPreference;
        this.waterRequirement = waterRequirement;
    }
}
