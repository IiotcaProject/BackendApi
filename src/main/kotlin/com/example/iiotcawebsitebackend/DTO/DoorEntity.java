package com.example.iiotcawebsitebackend.DTO;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // Provides getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Default constructor
@AllArgsConstructor // Constructor with all fields
@Builder // Enables builder pattern for the entity
@Getter
public class DoorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfDoors;
    public Integer openDoor; // Nullable to represent no door is open initially
}