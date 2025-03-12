package DetectivesControladorEvidencia.ControladorEvidencia

import Clientes.Evidencia.ModelsEvidencia.Evidencia
import ClientesEvidencia.ModelsEvidencia.TipoEvidencia

class ControladorEvidencia {
    private val evidencias = mutableListOf<Evidencia>()

    fun iniciar() {
        while (true) {
            println("\n--- Gestión de Evidencias ---")
            println("1. Agregar Clientes.Evidencia")
            println("2. Editar Clientes.Evidencia")
            println("3. Eliminar Clientes.Evidencia")
            println("4. Mostrar Evidencias")
            println("5. Buscar Evidencias por ID de Caso")
            println("6. Salir")
            print("Seleccione una opción: ")

            when (readln().toIntOrNull()) {
                1 -> agregarEvidencia()
                2 -> editarEvidencia()
                3 -> eliminarEvidencia()
                4 -> mostrarEvidencias()
                5 -> buscarEvidenciasPorCaso()
                6 -> {
                    println("Saliendo...")
                    break
                }
                else -> println("Opción inválida, intente de nuevo.")
            }
        }
    }

    private fun agregarEvidencia() {
        print("Ingrese el ID del caso relacionado: ")
        val idCaso = readln().takeIf { it.isNotBlank() } ?: return println("Error: El ID del caso es obligatorio.")

        print("Ingrese el ID de la evidencia: ")
        val id = readln().takeIf { it.isNotBlank() } ?: return println("Error: El ID de la evidencia es obligatorio.")

        print("Ingrese la descripción: ")
        val descripcion = readln().takeIf { it.isNotBlank() } ?: return println("Error: La descripción es obligatoria.")

        print("Ingrese la fecha (YYYY-MM-DD): ")
        val fecha = readln().takeIf { it.isNotBlank() } ?: return println("Error: La fecha es obligatoria.")

        val tipo = seleccionarTipoEvidencia()

        evidencias.add(Evidencia(id, descripcion, fecha, tipo, idCaso))
        println("Clientes.Evidencia agregada exitosamente.")
    }

    private fun editarEvidencia() {
        mostrarEvidencias()
        if (evidencias.isEmpty()) return

        print("Seleccione el índice de la evidencia a editar: ")
        val indice = readln().toIntOrNull() ?: return println("Índice inválido.")

        if (indice in evidencias.indices) {
            print("Nuevo ID: ")
            val nuevoId = readln().takeIf { it.isNotBlank() } ?: return println("Error: El ID de la evidencia es obligatorio.")

            print("Nueva descripción: ")
            val nuevaDescripcion = readln().takeIf { it.isNotBlank() } ?: return println("Error: La descripción es obligatoria.")

            print("Nueva fecha (YYYY-MM-DD): ")
            val nuevaFecha = readln().takeIf { it.isNotBlank() } ?: return println("Error: La fecha es obligatoria.")

            val nuevoTipo = seleccionarTipoEvidencia()
            print("Nuevo ID del caso relacionado: ")
            val nuevoIdCaso = readln().takeIf { it.isNotBlank() } ?: return println("Error: El ID del caso es obligatorio.")

            evidencias[indice] = Evidencia(nuevoId, nuevaDescripcion, nuevaFecha, nuevoTipo, nuevoIdCaso)
            println("Clientes.Evidencia actualizada.")
        } else {
            println("Índice inválido.")
        }
    }

    private fun eliminarEvidencia() {
        mostrarEvidencias()
        if (evidencias.isEmpty()) return

        print("Seleccione el índice de la evidencia a eliminar: ")
        val indice = readln().toIntOrNull() ?: return println("Índice inválido.")

        if (indice in evidencias.indices) {
            evidencias.removeAt(indice)
            println("Clientes.Evidencia eliminada.")
        } else {
            println("Índice inválido.")
        }
    }

    private fun mostrarEvidencias() {
        if (evidencias.isEmpty()) {
            println("No hay evidencias registradas.")
        } else {
            println("\n--- Lista de Evidencias ---")
            evidencias.forEachIndexed { index, evidencia -> println("$index. $evidencia") }
        }
    }

    private fun buscarEvidenciasPorCaso() {
        print("Ingrese el ID del caso: ")
        val idCaso = readln()

        val evidenciasFiltradas = evidencias.filter { it.idCaso == idCaso }
        if (evidenciasFiltradas.isEmpty()) {
            println("No se encontraron evidencias para el caso con ID: $idCaso")
        } else {
            println("\n--- Evidencias del Caso $idCaso ---")
            evidenciasFiltradas.forEachIndexed { index, evidencia -> println("$index. $evidencia") }
        }
    }

    private fun seleccionarTipoEvidencia(): TipoEvidencia {
        while (true) {
            println("Seleccione el tipo de evidencia:")
            println("1. Imagen")
            println("2. Video")
            println("3. Documento")
            println("4. Audio")
            print("Opción: ")
            when (readln().toIntOrNull()) {
                1 -> return TipoEvidencia.IMAGEN
                2 -> return TipoEvidencia.VIDEO
                3 -> return TipoEvidencia.DOCUMENTO
                4 -> return TipoEvidencia.AUDIO
                else -> println("Opción inválida, intente de nuevo.")
            }
        }
    }
}