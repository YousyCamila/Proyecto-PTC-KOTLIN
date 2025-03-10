package Casos

import Models.Caso

class CasoService {
    val nombresPermitidos = mapOf(
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

        val cliente = BaseDatosTemporal.clientes.firstOrNull { it.id == datos.idCliente }
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

    fun obtenerCasosPorClienteId(idCliente: String): List<Caso> {
        return BaseDatosTemporal.casos.filter { it.idCliente == idCliente.trim() }
    }

    fun obtenerCasosPorEmailCliente(emailCliente: String): List<Caso> {
        return BaseDatosTemporal.clientes.find { it.correo == emailCliente }?.casos
            ?: throw IllegalArgumentException("No se encontró un cliente con el email: $emailCliente")
    }

    fun obtenerCasosPorEmailDetective(emailDetective: String): List<Caso> {
        return BaseDatosTemporal.detectives.find { it.correo == emailDetective }?.casos
            ?: throw IllegalArgumentException("No se encontró un detective con el email: $emailDetective")
    }

    fun listarCasos(): List<Caso> {
        if (BaseDatosTemporal.casos.isEmpty()) throw IllegalStateException("No hay casos registrados actualmente.")
        return BaseDatosTemporal.casos
    }

    fun buscarCasoPorId(id: String): Caso {
        return BaseDatosTemporal.casos.find { it.id == id }
            ?: throw IllegalArgumentException("Caso no encontrado")
    }

    fun desactivarCaso(id: String): Caso {
        val caso = buscarCasoPorId(id)
        caso.activo = false
        return caso
    }
}