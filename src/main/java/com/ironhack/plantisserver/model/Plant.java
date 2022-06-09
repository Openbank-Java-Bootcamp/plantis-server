package com.ironhack.plantisserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.plantisserver.enums.Light;
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
    private Light lightPreference;
    @NotEmpty(message = "Provide a water quantity.")
    private String waterRequirement;
    @Size(min=3,max=200, message="Must be between 3 and 200 characters.")
    private String notes;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
