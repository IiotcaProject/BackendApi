package com.example.iiotcawebsitebackend.Controllers

import com.example.iiotcawebsitebackend.DTO.OpenSignalDto
import com.example.iiotcawebsitebackend.Services.OpenSignalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/openSignal")
@CrossOrigin(origins = ["*"])
class OpenSignalController @Autowired constructor(
    private val service: OpenSignalService
) {
    @PostMapping
    fun open(@RequestBody openSignalDto: OpenSignalDto): ResponseEntity<Unit> {
        return ResponseEntity.ok(service.create(openSignalDto))
    }
}
