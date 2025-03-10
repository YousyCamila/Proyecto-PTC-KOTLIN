package Casos

import Casos.Models.Caso
import Casos.Models.Detective
import Administrador.Clientes.Clientes

class CasoService {
    private val nombresPermitidos = mapOf(
        1 to "Cadena de custodia",
        2 to "Investigación de extorsión",
        3 to "Estudios de seguridad",
        4 to "Investigación de infidelidades",
        5 to "Investigación de robos empresariales",
        6 to "Antecedentes",
        7 to "Recuperación de vehículos"
    )

    fun crearCaso(datos: Caso): Caso? {
        if (BaseDatosTemporal.casos.any { it.id == datos.id }) {
            println("Error: Ya existe un caso con el ID ${datos.id}")
            return null
        }

        // Buscar cliente y detective por su ID
        val cliente = Clientes.clientes.firstOrNull { it.persona.id == datos.idCliente }
        val detective = BaseDatosTemporal.detectives.firstOrNull { it.id == datos.idDetective }

        if (cliente == null || detective == null) {
            println("Error: Cliente o detective no encontrados.")
            return null
        }

        return datos.apply {
            BaseDatosTemporal.casos.add(this)
            cliente.agregarCaso(this)
            detective.agregarCaso(this)
        }
    }

    fun obtenerCasosPorEmailCliente(emailCliente: String): List<Caso> {
        val cliente = Clientes.clientes.firstOrNull { it.persona.correo == emailCliente }
            ?: throw IllegalArgumentException("No se encontró un cliente con el email: $emailCliente")

        return BaseDatosTemporal.casos.filter { it.idCliente == cliente.persona.id }
    }

    fun obtenerCasosPorEmailDetective(emailDetective: String): List<Caso> {
        return BaseDatosTemporal.detectives.firstOrNull { it.correo == emailDetective }?.casos
            ?: throw IllegalArgumentException("No se encontró un detective con el email: $emailDetective")
    }

    fun listarCasos(): List<Caso> {
        return BaseDatosTemporal.casos.takeIf { it.isNotEmpty() }
            ?: throw IllegalStateException("No hay casos registrados actualmente.")
    }

    fun buscarCasoPorId(id: String): Caso {
        return BaseDatosTemporal.casos.firstOrNull { it.id == id }
            ?: throw IllegalArgumentException("Caso no encontrado")
    }

    fun desactivarCaso(id: String): Caso {
        val caso = buscarCasoPorId(id)

        if (!caso.activo) {
            println("El caso con ID $id ya está desactivado.")
            return caso
        }

        return caso.apply { activo = false }
    }
}
