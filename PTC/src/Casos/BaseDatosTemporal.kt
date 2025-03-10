package Casos

import Casos.Models.Caso
import Casos.Models.Detective
import Administrador.Clientes.Clientes
import Persona.Persona

object BaseDatosTemporal {
    val casos = mutableListOf<Caso>()
    val clientes = Clientes.clientes.toMutableList()
    val detectives = mutableListOf<Detective>()

    init {
        val cliente1 = Clientes(Persona("4","Sebastian Ordoñez", 314880935, "Crr 17H BIS", "juanseordo2206@gmail.com"))
        val cliente2 = Clientes(Persona("5","Laura Pérez", 315880931, "Crr 20A", "laura@gmail.com"))

        val detective1 = Detective("1", "detective1@example.com")
        val detective2 = Detective("2", "detective2@example.com")

        clientes.addAll(listOf(cliente1, cliente2))
        detectives.addAll(listOf(detective1, detective2))

        val caso1 = Caso("101", "Estudios de seguridad", "4", "1")  // Cliente ID = 4, Detective ID = 1
        val caso2 = Caso("102", "Investigación de infidelidades", "5", "2") // Cliente ID = 5, Detective ID = 2

        casos.addAll(listOf(caso1, caso2))
        cliente1.agregarCaso(caso1)
        cliente2.agregarCaso(caso2)
        detective1.agregarCaso(caso1)
        detective2.agregarCaso(caso2)
    }
}
