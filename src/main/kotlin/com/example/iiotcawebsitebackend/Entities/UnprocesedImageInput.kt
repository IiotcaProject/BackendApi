package com.example.iiotcawebsitebackend.Entities

import jakarta.persistence.*
import java.sql.Timestamp

@Entity
data class UnprocesedImageInput(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var unprocesedImageId : Long = 0,
    @Column(length = 10000000)
    var unprocesedImageList: String  = "",

    var dateTime : Timestamp =Timestamp(System.currentTimeMillis())
)
