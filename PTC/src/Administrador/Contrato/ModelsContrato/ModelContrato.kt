package Administrador.Contrato.ModelsContrato

import Administrador.Clientes.ModelsCliente.Clientes
import Administrador.Contrato.ControladorContrato.Contrato
import java.text.SimpleDateFormat
import java.util.*

class ModelContrato {
    companion object {
        val listaContratos = mutableListOf<Contrato>()
    }

    fun agregarContrato() {
        println(" Agregar un nuevo contrato")


        if (Clientes.clientes.isEmpty()) {
            println("⚠ No hay clientes registrados.")
            return
        }


        println("Seleccione un cliente para asignarle el contrato:")
        Clientes.clientes.forEachIndexed { index, cliente ->
            println("${index + 1}. ${cliente.persona.nombre}")
        }

        val seleccion = readln().toIntOrNull()
        if (seleccion == null || seleccion !in 1..Clientes.clientes.size) {
            println(" Selección inválida.")
            return
        }

        val clienteSeleccionado = Clientes.clientes[seleccion - 1]


        println("Ingrese la descripción del servicio:")
        val descripcion = readln()

        println("Ingrese la fecha de inicio (formato: yyyy-MM-dd):")
        val fechaInicio = convertirFecha(readln())

        println("Ingrese la fecha de cierre (formato: yyyy-MM-dd):")
        val fechaCierre = convertirFecha(readln())

        println("Ingrese las cláusulas del contrato:")
        val clausulas = readln()

        println("Ingrese la tarifa:")
        val tarifa = readln().toFloatOrNull() ?: 0f

        println("Estado del contrato (true = activo, false = inactivo):")
        val estado = readln().toBoolean()


        val nuevoContrato = Contrato(descripcion, fechaInicio, fechaCierre, clausulas, tarifa, estado, clienteSeleccionado)
        listaContratos.add(nuevoContrato)

        println(" Contrato creado con éxito para el cliente ${clienteSeleccionado.persona.nombre}.")
    }

    private fun convertirFecha(fechaStr: String): Date {
        val formato = SimpleDateFormat("yyyy-MM-dd")
        return try {
            formato.parse(fechaStr)
        } catch (e: Exception) {
            println(" Formato incorrecto, se usará la fecha actual.")
            Date()
        }
    }
}
