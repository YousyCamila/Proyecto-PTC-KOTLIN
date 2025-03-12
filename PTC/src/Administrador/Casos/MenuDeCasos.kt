package Administrador.Casos

import Administrador.Casos.ControladorCaso.CasoService
import Administrador.Casos.Models.Caso

class MenuCaso {
     val casoService = CasoService()

    fun mostrarMenu() {
        while (true) {
            println("\nMenú de Gestión de Casos")
            println("1. Crear Caso")
            println("2. Listar Casos")
            println("3. Buscar Caso por ID")
            println("4. Desactivar Caso")
            println("5. Buscar Casos por Email Cliente")
            println("6. Buscar Casos por Email Detective")
            println("7. Salir")
            print("Seleccione una opción: ")

            when (readln()?.toIntOrNull()) {
                1 -> crearCaso()
                2 -> listarCasos()
                3 -> buscarCasoPorId()
                4 -> desactivarCaso()
                5 -> buscarCasosPorEmailCliente()
                6 -> buscarCasosPorEmailDetective()
                7 -> return
                else -> println("Opción no válida")
            }
        }
    }

     fun crearCaso() {
        println("Ingrese ID del caso: ")
        val id = readln().orEmpty()
        println("Ingrese Nombre del Caso: ")
        val nombreCaso = readln().orEmpty()
        println("Ingrese ID del Cliente: ")
        val idCliente = readln().orEmpty()
        println("Ingrese ID del Detective: ")
        val idDetective = readln().orEmpty()
        try {
            val caso = casoService.crearCaso(Caso(id, nombreCaso, idCliente, idDetective))
            println("Caso creado: $caso")
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

     fun listarCasos() {
        println("Casos: ${casoService.listarCasos()}")
    }

    fun buscarCasoPorId() {
        println("Ingrese ID del caso: ")
        val id = readln().orEmpty()
        println("Caso encontrado: ${casoService.buscarCasoPorId(id)}")
    }

     fun desactivarCaso() {
        println("Ingrese ID del caso a desactivar: ")
        val id = readln().orEmpty()
        println("Caso desactivado: ${casoService.desactivarCaso(id)}")
    }

     fun buscarCasosPorEmailCliente() {
        println("Ingrese email del cliente: ")
        val email = readln().orEmpty()
        println("Casos del cliente: ${casoService.obtenerCasosPorEmailCliente(email)}")
    }

     fun buscarCasosPorEmailDetective() {
        println("Ingrese email del detective: ")
        val email = readln().orEmpty()
        println("Casos del detective: ${casoService.obtenerCasosPorEmailDetective(email)}")
    }
}
