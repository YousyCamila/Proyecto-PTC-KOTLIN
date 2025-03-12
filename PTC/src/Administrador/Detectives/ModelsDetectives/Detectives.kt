package Administrador.Detectives.ModelsDetectives
import Administrador.Casos.Models.Caso


import Persona.Persona

class Detectives(val persona: Persona) {

    val casos = mutableListOf<Caso>()

    private fun datosDetective() {

        println("Id ${persona.id}  ")
        println("Detective ${persona.nombre}  ")
        println("Celular: ${persona.celular}")
        println("Dirección: ${persona.direccion}")
        println("Correo: ${persona.correo}")
    }
    fun agregarCaso(caso: Caso) {
        casos.add(caso)
    }

    companion object {
        val listaDetectives = mutableListOf(
            Detectives(Persona("1","Ludwig Smirh", 321269946, "calle 25 s", "ludwig@gmail.com")),
            Detectives(Persona("2","Wolfgang Steve", 321264566, "calle 60 n", "wolfgang@gmail.com")),
            Detectives(Persona("3","Cristian Cardona", 311600120, "avenida el dorado", "cristian@gmail.com"))
        )
    }
}
