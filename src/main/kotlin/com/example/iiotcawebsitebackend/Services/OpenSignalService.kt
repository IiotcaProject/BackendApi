package com.example.iiotcawebsitebackend.Services

import com.example.iiotcawebsitebackend.DTO.OpenSignalDto
import com.example.iiotcawebsitebackend.Entities.OpenSignal
import com.example.iiotcawebsitebackend.Repository.OpenSignalRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OpenSignalService @Autowired constructor(
    private var repository: OpenSignalRepository
){
    fun create(openSignalDto : OpenSignalDto){
        val openSignal : OpenSignal = OpenSignal()
        openSignal.open = openSignalDto.open
        openSignal.doorId = openSignalDto.doorId
        repository.save(openSignal)
    }

    fun returnLast() : OpenSignal?{
        return repository.findAll().lastOrNull()
    }
}
