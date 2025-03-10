package Evidencia

import Casos.Models.Caso
import java.util.*

class EvidenciaMenu {
    fun gestionarCasos() {
        val scanner = Scanner(System.`in`)
        val casos = mutableListOf<Caso>()

        while (true) {
            println("\n=== Gestión de Casos ===")
            println("1. Crear Caso")
            println("2. Listar Casos")
            println("3. Volver al Menú Principal")
            print("Seleccione una opción: ")

            when (scanner.nextInt()) {
                1 -> {
                    scanner.nextLine()
                    print("Ingrese el ID del caso: ")
                    val id = scanner.nextLine()
                    print("Ingrese el nombre del caso: ")
                    val nombreCaso = scanner.nextLine()
                    print("Ingrese el ID del cliente: ")
                    val idCliente = scanner.nextLine()
                    print("Ingrese el ID del detective: ")
                    val idDetective = scanner.nextLine()

                    casos.add(Caso(id, nombreCaso, idCliente, idDetective))
                    println("Caso creado exitosamente.")
                }
                2 -> {
                    if (casos.isEmpty()) {
                        println("No hay casos registrados.")
                    } else {
                        println("\n=== Lista de Casos ===")
                        casos.forEachIndexed { index, caso ->
                            println("${index + 1}. ID: ${caso.id} - Nombre: ${caso.nombreCaso} - Cliente: ${caso.idCliente} - Detective: ${caso.idDetective}")
                        }
                    }
                }
                3 -> return
                else -> println("Opción inválida, intente de nuevo.")
            }
        }
    }

}