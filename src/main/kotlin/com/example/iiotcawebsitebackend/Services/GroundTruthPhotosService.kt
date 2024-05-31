package com.example.iiotcawebsitebackend.Services

import com.example.iiotcawebsitebackend.DTO.GroundTruthDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import com.example.iiotcawebsitebackend.Entities.GroundTruthPhotos;
import com.example.iiotcawebsitebackend.Repository.GroundTruthPhotosRepository


@Service
class GroundTruthPhotosService @Autowired constructor(
    private val repository: GroundTruthPhotosRepository
) {

    fun create(groundTruthDto: GroundTruthDto): GroundTruthPhotos {
        val groundTruthPhotos = mapToEntity(groundTruthDto)
        return repository.save(groundTruthPhotos)
    }

    fun read(groundTruthPhotoId: Long): Optional<GroundTruthDto> {
        val groundTruthPhotos =repository.findById(groundTruthPhotoId)
        if (groundTruthPhotos.isPresent) {
            return Optional.of(mapToDto(groundTruthPhotos.get()))
        }
        return Optional.empty()
    }

    fun update(groundTruthPhotoId: Long, groundTruthDto: GroundTruthDto): Optional<GroundTruthDto> {
        return if (repository.existsById(groundTruthPhotoId)) {
            val groundTruthPhotos = mapToEntity(groundTruthDto)
            groundTruthPhotos.groundTruthPhotoId = groundTruthPhotoId
            repository.save(groundTruthPhotos)
            Optional.of(mapToDto(groundTruthPhotos))
        } else {
            Optional.empty()
        }
    }

    fun delete(groundTruthPhotoId: Long) {
        repository.deleteById(groundTruthPhotoId)
    }

    fun findAll(): List<GroundTruthDto> {
        return repository.findAll().map { g ->  mapToDto(g)}
    }

    // Convert PhotoDto to GroundTruthPhotos entity
    private fun mapToEntity(groundTruthDto: GroundTruthDto): GroundTruthPhotos {
        val photos = groundTruthDto.photoList
        val name = groundTruthDto.name
        return GroundTruthPhotos(photos = photos, name = name)
    }

    // Convert GroundTruthPhotos entity to PhotoDto
    private fun mapToDto(groundTruthPhotos: GroundTruthPhotos): GroundTruthDto {
        val photoList = groundTruthPhotos.photos
        val name = groundTruthPhotos.name
        val id = groundTruthPhotos.groundTruthPhotoId.toInt()
        return GroundTruthDto(photoList = photoList, name = name, id = id)
    }
}
