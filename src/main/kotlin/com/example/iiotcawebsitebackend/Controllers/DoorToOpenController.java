package com.example.iiotcawebsitebackend.Controllers;
import com.example.iiotcawebsitebackend.DTO.DoorEntity;
import com.example.iiotcawebsitebackend.DTO.NrDoorsDto;
import com.example.iiotcawebsitebackend.Repository.DoorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/doors")
@RequiredArgsConstructor
public class DoorToOpenController {

    private final DoorRepository doorRepository;

    @PostMapping("/number-of-doors-to-open")
    public ResponseEntity<DoorEntity> setNumberOfDoors(@RequestBody NrDoorsDto nrDoorsDto) {
        DoorEntity doorEntity = doorRepository.findAll().stream().findFirst().orElse(DoorEntity.builder().build());
        doorEntity.setNumberOfDoors(nrDoorsDto.getNrOfDoors());
        DoorEntity savedEntity = doorRepository.save(doorEntity);
        return ResponseEntity.ok(savedEntity); // Return HTTP 200 OK with the saved entity
    }

    @PostMapping("/door-to-open")
    public ResponseEntity<DoorEntity> setDoorToOpen(@RequestBody int doorIndex) {
        DoorEntity doorEntity = doorRepository.findAll().stream().findFirst().orElseThrow(() ->
                new IllegalStateException("Number of doors is not set. Please set it first.")
        );
        doorEntity.setOpenDoor(doorIndex);
        DoorEntity savedEntity = doorRepository.save(doorEntity);
        return ResponseEntity.ok(savedEntity); // Return HTTP 200 OK with the updated entity
    }

    @GetMapping("/number-of-doors-to-open")
    public ResponseEntity<Integer> getNumberOfDoors() {
        DoorEntity doorEntity = doorRepository.findAll().stream().findFirst().orElseThrow(() ->
                new IllegalStateException("Number of doors is not set. Please set it first.")
        );
        return ResponseEntity.ok(doorEntity.getNumberOfDoors());
    }
}
