package com.example.iiotcawebsitebackend.Repository

import com.example.iiotcawebsitebackend.Entities.UnprocesedImageInput
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UnprocesedImageInputRepository : JpaRepository<UnprocesedImageInput, Long>
