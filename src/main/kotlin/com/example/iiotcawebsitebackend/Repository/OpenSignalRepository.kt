package com.example.iiotcawebsitebackend.Repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.example.iiotcawebsitebackend.Entities.OpenSignal

@Repository
interface OpenSignalRepository : JpaRepository<OpenSignal, Long>
