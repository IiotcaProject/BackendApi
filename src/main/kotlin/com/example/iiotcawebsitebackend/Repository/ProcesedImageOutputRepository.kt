package com.example.iiotcawebsitebackend.Repositories

import com.example.iiotcawebsitebackend.Entities.ProcesedImageOutput
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProcesedImageOutputRepository : JpaRepository<ProcesedImageOutput, Long>
