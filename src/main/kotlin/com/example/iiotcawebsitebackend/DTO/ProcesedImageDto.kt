package com.example.iiotcawebsitebackend.DTO

import java.time.Instant

data class ProcesedImageDto(
//    var photoList : String = " ",
    var dateTime : Instant = Instant.now(),
    var faceDetected:Boolean = false,
    var faceRecognized:Boolean = false,
    var recognizedPeople : List<String> = emptyList(),
    var nrOfPastFramesWithDetection : Int = 0,
    var nrOfPastFramesWithRecognition : Int = 0
)
