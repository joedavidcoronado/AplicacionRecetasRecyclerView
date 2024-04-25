package com.example.practico2ingredientes.model

import java.io.Serializable

class Ingrediente(
    var estado: Boolean,
    var id: Int,
    var nombre: String,
    var imagenUrl: String
) : Serializable {
    override fun toString(): String {
        return nombre
    }
}
