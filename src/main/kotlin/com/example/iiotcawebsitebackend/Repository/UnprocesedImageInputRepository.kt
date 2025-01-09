package com.example.iiotcawebsitebackend.Repository

import com.example.iiotcawebsitebackend.Entities.UnprocesedImageInput
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.sql.Timestamp

@Repository
interface UnprocesedImageInputRepository : JpaRepository<UnprocesedImageInput, Long> {

    @Modifying
    @Transactional    @Query("DELETE FROM UnprocesedImageInput u WHERE u.dateTime < :threshold")
    fun deleteOldRecords(threshold: Timestamp)
}