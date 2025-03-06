package Administrador.Clientes

import Persona.Persona

class Clientes(val persona: Persona) {

    private fun datosCliente() {

        println("Cliente ${persona.nombre}  ")
        println("Celular: ${persona.celular}")
        println("Dirección: ${persona.direccion}")
        println("Correo: ${persona.correo}")

    }

    companion object {

        val clientes = mutableListOf(

            Clientes(Persona("Danna Camila", 321269946, "Crr 17H BIS", "dcami@gmail.com")),
            Clientes(Persona("Oriana Guerra", 321264566, "Crr 18H BIS", "ori@gmail.com")),
            Clientes(Persona("Martin Emilio", 311600120, "Crr 25H BIS", "martin@gmail.com"))
        )


    }

}


