package com.example.iiotcawebsitebackend.Repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.example.iiotcawebsitebackend.Entities.GroundTruthPhotos
@Repository
interface GroundTruthPhotosRepository : JpaRepository<GroundTruthPhotos, Long>

