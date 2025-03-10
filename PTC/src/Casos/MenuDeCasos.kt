package Casos

import Casos.Models.Caso
import java.util.*

fun MenuDeCasos() {
    val casoService = CasoService()
    val scanner = Scanner(System.`in`)

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

        when (scanner.nextInt()) {
            1 -> {
                println("Ingrese ID del caso: ")
                val id = scanner.next()
                println("Ingrese Nombre del Caso: ")
                val nombreCaso = scanner.next()
                println("Ingrese ID del Cliente: ")
                val idCliente = scanner.next()
                println("Ingrese ID del Detective: ")
                val idDetective = scanner.next()
                try {
                    val caso = casoService.crearCaso(Caso(id, nombreCaso, idCliente, idDetective))
                    println("Caso: $caso")
                } catch (e: Exception) {
                    println("Error: ${e.message}")
                }
            }
            2 -> println("Casos: ${casoService.listarCasos()}")
            3 -> {
                println("Ingrese ID del caso: ")
                val id = scanner.next()
                println("Caso encontrado: ${casoService.buscarCasoPorId(id)}")
            }
            4 -> {
                println("Ingrese ID del caso a desactivar: ")
                val id = scanner.next()
                println("Caso desactivado: ${casoService.desactivarCaso(id)}")
            }
            5 -> {
                println("Ingrese email del cliente: ")
                val email = scanner.next()
                println("Casos del cliente: ${casoService.obtenerCasosPorEmailCliente(email)}")
            }
            6 -> {
                println("Ingrese email del detective: ")
                val email = scanner.next()
                println("Casos del detective: ${casoService.obtenerCasosPorEmailDetective(email)}")
            }
            7 -> return
            else -> println("Opción no válida")
        }
    }
}
