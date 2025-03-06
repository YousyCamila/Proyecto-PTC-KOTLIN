package Administrador

import Administrador.Clientes.Clientes
import java.util.*

class DatosContrato(
    private var descripcionServicio: String,
    private var fechaInicio: Date,
    private var fechaCierre: Date,
    private var clausulas: String,
    private var tarifa: Float,
    private var estado: Boolean,
    private var cliente: Clientes
) {
    // Getters
    fun getDescripcionServicio() = descripcionServicio
    fun getFechaInicio() = fechaInicio
    fun getFechaCierre() = fechaCierre
    fun getClausulas() = clausulas
    fun getTarifa() = tarifa
    fun getEstado() = estado
    fun getCliente() = cliente
}
