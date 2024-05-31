package com.example.iiotcawebsitebackend.Controllers



import com.example.iiotcawebsitebackend.DTO.OpenSignalDto
import com.example.iiotcawebsitebackend.DTO.ProcesedImageDto
import com.example.iiotcawebsitebackend.Services.OpenSignalService
import com.example.iiotcawebsitebackend.Services.ProcesedImageOutputService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/procesedImageOutput")
@CrossOrigin(origins = ["*"])
class ProcesedImageOutputController @Autowired constructor(
    private val service: ProcesedImageOutputService,
    private val service2 : OpenSignalService
) {
    @GetMapping("/getOpenSignal")
    fun getOpenSignal(): ResponseEntity<Void> {
        val lastImage = service.getLastProcessedImage()
        return if ((lastImage.isPresent && lastImage.get().pastFramesDetection >= 6 && lastImage.get().pastFramesRecognition >= 6) || (service2.returnLast() != null && service2.returnLast()!!.open.equals(true))) {
            service2.create(OpenSignalDto(open = false))
            ResponseEntity(HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.EXPECTATION_FAILED)
        }
    }
    @PostMapping
    fun create(@RequestBody dto: ProcesedImageDto): ResponseEntity<Void> {
        service.create(dto)
        return ResponseEntity(HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): ResponseEntity<ProcesedImageDto> {
        val entity = service.read(id)
        return entity.map { ResponseEntity.ok(it) }
            .orElseGet { ResponseEntity.notFound().build() }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: ProcesedImageDto): ResponseEntity<Void> {
        val updated = service.update(id, dto)
        return  ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<ProcesedImageDto>> {
        return ResponseEntity.ok(service.findAll())
    }
}
