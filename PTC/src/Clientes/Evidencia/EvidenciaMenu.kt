package Clientes.Evidencia

import Administrador.Casos.Models.Caso

class EvidenciaMenu {
    fun gestionarCasos() {
        val casos = mutableListOf<Caso>()

        while (true) {
            println("\n=== Gestión de Administrador.Casos ===")
            println("1. Crear Caso")
            println("2. Listar Administrador.Casos")
            println("3. Volver al Menú Principal")
            print("Seleccione una opción: ")

            when (readln().toIntOrNull()) {
                1 -> {
                    print("Ingrese el ID del caso: ")
                    val id = readln()
                    print("Ingrese el nombre del caso: ")
                    val nombreCaso = readln()
                    print("Ingrese el ID del cliente: ")
                    val idCliente = readln()
                    print("Ingrese el ID del detective: ")
                    val idDetective = readln()

                    casos.add(Caso(id, nombreCaso, idCliente, idDetective))
                    println("Caso creado exitosamente.")
                }
                2 -> {
                    if (casos.isEmpty()) {
                        println("No hay casos registrados.")
                    } else {
                        println("\n=== Lista de Administrador.Casos ===")
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