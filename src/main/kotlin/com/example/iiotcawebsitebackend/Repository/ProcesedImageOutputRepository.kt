package com.example.iiotcawebsitebackend.Repositories

import com.example.iiotcawebsitebackend.Entities.ProcesedImageOutput
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.sql.Timestamp

@Repository
interface ProcesedImageOutputRepository : JpaRepository<ProcesedImageOutput, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM ProcesedImageOutput p WHERE p.dateTime < :cutoffTime")
    fun deleteOlderThan(cutoffTime: Timestamp)
}
