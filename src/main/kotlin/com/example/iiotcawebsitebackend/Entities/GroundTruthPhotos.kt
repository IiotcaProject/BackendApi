package com.example.iiotcawebsitebackend.Entities

import jakarta.persistence.*

@Entity
data class GroundTruthPhotos (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var groundTruthPhotoId:Long = 0,
    @Column(length = 50000000)
    var photos: String = " ",
    var name : String = " "
)
