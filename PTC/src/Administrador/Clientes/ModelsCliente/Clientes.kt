package Administrador.Clientes.ModelsCliente
import Administrador.Casos.Models.Caso

import Persona.Persona

class Clientes(val persona: Persona) {

    private val casos = mutableListOf<Caso>()

    private fun datosCliente() {
        println("Id ${persona.id}  ")
        println("Cliente ${persona.nombre}  ")
        println("Celular: ${persona.celular}")
        println("Dirección: ${persona.direccion}")
        println("Correo: ${persona.correo}")

    }
    fun agregarCaso(caso: Caso) {
        casos.add(caso)
    }

    companion object {

        val clientes = mutableListOf(

            Clientes(Persona("1","Danna Camila", 321269946, "Crr 17H BIS", "dcami@gmail.com")),
            Clientes(Persona("2","Oriana Guerra", 321264566, "Crr 18H BIS", "ori@gmail.com")),
            Clientes(Persona("3","Martin Emilio", 311600120, "Crr 25H BIS", "martin@gmail.com"))
        )


    }

}


