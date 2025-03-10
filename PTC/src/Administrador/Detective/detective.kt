package Administrador.Detectives

import Persona.Persona

class Detectives(val persona: Persona) {

    private fun datosDetective() {
        println("Detective ${persona.nombre}  ")
        println("Celular: ${persona.celular}")
        println("Dirección: ${persona.direccion}")
        println("Correo: ${persona.correo}")
    }

    companion object {
        val listaDetectives = mutableListOf(
            Detectives(Persona("Ludwig Smirh", 321269946, "calle 25 s", "ludwig@gmail.com")),
            Detectives(Persona("Wolfgang Steve", 321264566, "calle 60 n", "wolfgang@gmail.com")),
            Detectives(Persona("Cristian Cardona", 311600120, "avenida el dorado", "cristian@gmail.com"))
        )
    }
}
