package com.example.iiotcawebsitebackend.Repository;
import com.example.iiotcawebsitebackend.DTO.DoorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoorRepository extends JpaRepository<DoorEntity, Long> {
}