package com.example.iiotcawebsitebackend.Services

import com.example.iiotcawebsitebackend.DTO.UnprocesedImageDto
import com.example.iiotcawebsitebackend.Entities.UnprocesedImageInput
import com.example.iiotcawebsitebackend.Repository.UnprocesedImageInputRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.Instant
import java.util.*

@Service
class UnprocesedImageInputService @Autowired constructor(
    private val repository: UnprocesedImageInputRepository
) {
    @Scheduled(fixedRate = 10000) // Run every 1 minute
    fun cleanOldRecords() {
        val oneMinuteAgo = Timestamp.from(Instant.now().minusSeconds(20))
        repository.deleteOldRecords(oneMinuteAgo)
    }
    fun create(dto:UnprocesedImageDto): UnprocesedImageDto {
        val entity = mapToEntity(dto)
        val savedEntity = repository.save(entity)
        return mapToDto(savedEntity)
    }

    fun read(unprocesedImageId: Long): Optional<UnprocesedImageDto> {
        return repository.findById(unprocesedImageId).map { mapToDto(it) }
    }

    fun update(unprocesedImageId: Long, dto: UnprocesedImageDto): Optional<UnprocesedImageDto> {
        return if (repository.existsById(unprocesedImageId)) {
            val entity = mapToEntity(dto)
            entity.unprocesedImageId = unprocesedImageId
            val updatedEntity = repository.save(entity)
            Optional.of(mapToDto(updatedEntity))
        } else {
            Optional.empty()
        }
    }

    fun delete(unprocesedImageId: Long) {
        repository.deleteById(unprocesedImageId)
    }

    fun findAll(): List<UnprocesedImageDto> {
        return repository.findAll().map { mapToDto(it) }
    }

    private fun mapToEntity(dto: UnprocesedImageDto): UnprocesedImageInput {
        val imageList = dto.photoList
        return UnprocesedImageInput(
            unprocesedImageList = imageList,
            dateTime = Timestamp.from(dto.dateTime),
            doorId = dto.doorId
        )
    }

    private fun mapToDto(entity: UnprocesedImageInput): UnprocesedImageDto {
        val photoList = entity.unprocesedImageList
        return UnprocesedImageDto(
            photoList = photoList,
            dateTime = entity.dateTime.toInstant(),
            doorId = entity.doorId
        )
    }
}
