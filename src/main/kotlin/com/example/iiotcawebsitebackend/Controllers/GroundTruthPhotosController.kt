package com.example.iiotcawebsitebackend.Controllers

import com.example.iiotcawebsitebackend.DTO.GroundTruthDto
import com.example.iiotcawebsitebackend.Entities.GroundTruthPhotos
import com.example.iiotcawebsitebackend.Services.GroundTruthPhotosService
import com.example.iiotcawebsitebackend.Services.OpenSignalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/groundTruthPhotos")
@CrossOrigin(origins = ["*"] )
class GroundTruthPhotosController @Autowired constructor(
    private val service: GroundTruthPhotosService
) {

    @PostMapping
    fun create(@RequestBody photoDto: GroundTruthDto): ResponseEntity<GroundTruthPhotos> {
        return ResponseEntity.ok(service.create(photoDto))
    }

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): ResponseEntity<GroundTruthDto> {
        val groundTruthPhotos = service.read(id)
        return groundTruthPhotos.map { ResponseEntity.ok(it) }
            .orElseGet { ResponseEntity.notFound().build() }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody photoDto: GroundTruthDto): ResponseEntity<GroundTruthDto> {
        val updated = service.update(id, photoDto)
        return updated.map { ResponseEntity.ok(it) }
            .orElseGet { ResponseEntity.notFound().build() }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<GroundTruthDto>> {
        return ResponseEntity.ok(service.findAll())
    }
}
