package Casos

import Casos.Models.Caso
import Administrador.Clientes.Clientes
import Administrador.Detectives.Detectives

object BaseDatosTemporal {
    val casos = mutableListOf<Caso>()

    init {
        // Crear casos y asociarlos con clientes y detectives existentes
        val caso1 = Caso("101", "Estudios de seguridad", "4", "1")  // Cliente ID = 4, Detective ID = 1
        val caso2 = Caso("102", "Investigación de infidelidades", "5", "2") // Cliente ID = 5, Detective ID = 2

        casos.addAll(listOf(caso1, caso2))

        // Asociar casos con clientes y detectives
        val cliente1 = Clientes.clientes.find { it.persona.id == "4" }
        val cliente2 = Clientes.clientes.find { it.persona.id == "5" }

        val detective1 = Detectives.listaDetectives.find { it.persona.id == "1" }
        val detective2 = Detectives.listaDetectives.find { it.persona.id == "2" }

        cliente1?.agregarCaso(caso1)
        cliente2?.agregarCaso(caso2)
        detective1?.agregarCaso(caso1)
        detective2?.agregarCaso(caso2)
    }
}