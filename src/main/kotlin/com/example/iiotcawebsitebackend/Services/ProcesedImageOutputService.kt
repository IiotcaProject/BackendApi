package com.example.iiotcawebsitebackend.Services

import com.example.iiotcawebsitebackend.DTO.ProcesedImageDto
import com.example.iiotcawebsitebackend.Entities.ProcesedImageOutput
import com.example.iiotcawebsitebackend.Repositories.ProcesedImageOutputRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.util.*

@Service
class ProcesedImageOutputService @Autowired constructor(
    private val repository: ProcesedImageOutputRepository
) {

    fun create(dto: ProcesedImageDto): ProcesedImageDto {
        val entity = mapToEntity(dto)
        repository.save(entity)
        return mapToDto(entity)
    }

    fun read(procesedImageId: Long): Optional<ProcesedImageDto> {
        val entity = repository.findById(procesedImageId)
        if (entity.isPresent) {
            return Optional.of(mapToDto(entity.get()))
        }
        return Optional.empty()
    }

    fun update(procesedImageId: Long, dto: ProcesedImageDto): Optional<ProcesedImageOutput> {
        return if (repository.existsById(procesedImageId)) {
            val entity = mapToEntity(dto)
            entity.procesedImageId = procesedImageId
            Optional.of(repository.save(entity))
        } else {
            Optional.empty()
        }
    }

    fun delete(procesedImageId: Long) {
        repository.deleteById(procesedImageId)
    }

    fun findAll(): List<ProcesedImageDto> {
        return repository.findAll().map { g -> mapToDto(g)}
    }

    fun getLastProcessedImage(): Optional<ProcesedImageOutput> {
        return repository.findAll().stream()
            .max(Comparator.comparingLong(ProcesedImageOutput::procesedImageId))
    }


    private fun mapToEntity(dto: ProcesedImageDto): ProcesedImageOutput {
//        val imageList = dto.photoList
        val dateTime = Timestamp(System.currentTimeMillis())
        val faceDetected = dto.faceDetected
        val faceRecognized = dto.faceRecognized
        val recognizedPeople = dto.recognizedPeople
        val nrOfPastFramesWithDetection = dto.nrOfPastFramesWithDetection
        val nrOfPastFramesWithRecognition = dto.nrOfPastFramesWithRecognition
        return ProcesedImageOutput( faceDetected = faceDetected, dateTime = dateTime,
            faceRecognized = faceRecognized, recognizedPeople = recognizedPeople, pastFramesDetection = nrOfPastFramesWithDetection,
            pastFramesRecognition = nrOfPastFramesWithRecognition)
    }

    private fun mapToDto(entity: ProcesedImageOutput): ProcesedImageDto {
//        val imageList = entity.procesedImageList
        val dateTime = entity.dateTime.toInstant()
        val faceDetected = entity.faceDetected
        val faceRecognized = entity.faceRecognized
        val peopleRecognized = entity.recognizedPeople
        val nrOfPastFramesWithDetection = entity.pastFramesDetection
        val nrOfPastFramesWithRecognition = entity.pastFramesRecognition
        return ProcesedImageDto( dateTime = dateTime, faceDetected = faceDetected,
            recognizedPeople = peopleRecognized, faceRecognized = faceRecognized, nrOfPastFramesWithDetection = nrOfPastFramesWithDetection,
            nrOfPastFramesWithRecognition = nrOfPastFramesWithRecognition)
    }
}

