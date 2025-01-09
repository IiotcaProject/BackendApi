package com.example.iiotcawebsitebackend.Entities

import jakarta.persistence.*
import java.sql.Timestamp

@Entity
data class ProcesedImageOutput(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var procesedImageId : Long = 0,

//    @Column(length = 10000000)
//    var procesedImageList: String = "",

    var dateTime :Timestamp = Timestamp(System.currentTimeMillis()),
    var faceDetected : Boolean = false,
    var faceRecognized : Boolean = false,
    @ElementCollection
    var recognizedPeople : List<String> = emptyList(),
    var pastFramesDetection : Int = 0,
    var pastFramesRecognition : Int = 0,

    var doorId : Long = 0
)
