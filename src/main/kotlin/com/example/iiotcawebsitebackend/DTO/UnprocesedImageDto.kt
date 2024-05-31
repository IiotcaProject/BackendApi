package com.example.iiotcawebsitebackend.DTO

import java.time.Instant

data class UnprocesedImageDto(
    var photoList : String = "",
    var dateTime : Instant = Instant.now(),
    var name : String = ""
)
