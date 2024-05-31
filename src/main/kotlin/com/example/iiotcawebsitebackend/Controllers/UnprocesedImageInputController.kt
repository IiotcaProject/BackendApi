package com.example.iiotcawebsitebackend.Controllers

import com.example.iiotcawebsitebackend.DTO.UnprocesedImageDto
import com.example.iiotcawebsitebackend.Services.UnprocesedImageInputService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/unprocesedImageInput")
@CrossOrigin(origins = ["*"])
class UnprocesedImageInputController @Autowired constructor(
    private val service: UnprocesedImageInputService
) {

    @PostMapping
    fun create(@RequestBody dto: UnprocesedImageDto): ResponseEntity<Void> {
        service.create(dto)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): ResponseEntity<UnprocesedImageDto> {
        val entity = service.read(id)
        return entity.map { ResponseEntity.ok(it) }
            .orElseGet { ResponseEntity.notFound().build() }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: UnprocesedImageDto): ResponseEntity<Void> {
        val updated = service.update(id, dto)
        return  ResponseEntity.ok().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun findAll(): ResponseEntity<UnprocesedImageDto> {
        return ResponseEntity.ok(service.findAll().lastOrNull())
    }
}

