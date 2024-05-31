package com.example.iiotcawebsitebackend.Entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class OpenSignal(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Int  = 0,
    var open : Boolean = false

) {
}
