package Casos

import Models.Caso
import Models.Cliente
import Models.Detective

object BaseDatosTemporal {
    val casos = mutableListOf<Caso>()
    val clientes = mutableListOf<Cliente>()
    val detectives = mutableListOf<Detective>()

    init {
        val cliente1 = Cliente("1", "cliente1@example.com")
        val cliente2 = Cliente("2", "cliente2@example.com")
        val detective1 = Detective("1", "detective1@example.com")
        val detective2 = Detective("2", "detective2@example.com")

        clientes.addAll(listOf(cliente1, cliente2))
        detectives.addAll(listOf(detective1, detective2))

        val caso1 = Caso("101", "Estudios de seguridad", "1", "1")
        val caso2 = Caso("102", "Investigación de infidelidades", "2", "2")

        casos.addAll(listOf(caso1, caso2))
        cliente1.agregarCaso(caso1)
        cliente2.agregarCaso(caso2)
        detective1.agregarCaso(caso1)
        detective2.agregarCaso(caso2)
    }
}