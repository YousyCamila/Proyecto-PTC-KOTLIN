package Administrador.Clientes.ClientesDAO

import Administrador.Clientes.ModelsCliente.Clientes
import Database.DatabaseConnection
import Persona.Persona
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class ClientesDAO {
    fun obtenerTodosLosClientes(): List<Clientes> {
        val clientes = mutableListOf<Clientes>()
        val conexion: Connection? = DatabaseConnection.getConnection()

        try {
            val query = "SELECT id, nombre, celular, direccion, correo FROM Clientes"
            val statement: PreparedStatement = conexion!!.prepareStatement(query)
            val resultSet: ResultSet = statement.executeQuery()

            while (resultSet.next()) {
                val cliente = Clientes(
                    Persona(
                        id = resultSet.getString("id"),
                        nombre = resultSet.getString("nombre"),
                        celular = resultSet.getInt("celular"),
                        direccion = resultSet.getString("direccion"),
                        correo = resultSet.getString("correo")
                    )
                )
                clientes.add(cliente)
            }
        } catch (e: SQLException) {
            println("Error al obtener clientes: ${e.message}")
        } finally {
            conexion?.close()
        }

        return clientes
    }

    fun insertarCliente(cliente: Clientes): Boolean {
        val conexion: Connection? = DatabaseConnection.getConnection()
        return try {
            val query = "INSERT INTO Clientes (id, nombre, celular, direccion, correo) VALUES (?, ?, ?, ?, ?)"
            val statement: PreparedStatement = conexion!!.prepareStatement(query)
            statement.setString(1, cliente.persona.id)
            statement.setString(2, cliente.persona.nombre)
            statement.setInt(3, cliente.persona.celular)
            statement.setString(4, cliente.persona.direccion)
            statement.setString(5, cliente.persona.correo)

            statement.executeUpdate() > 0
        } catch (e: SQLException) {
            println("Error al insertar cliente: ${e.message}")
            false
        } finally {
            conexion?.close()
        }
    }

    fun actualizarCliente(cliente: Clientes): Boolean {
        val conexion: Connection? = DatabaseConnection.getConnection()
        return try {
            val query = "UPDATE Clientes SET nombre = ?, celular = ?, direccion = ?, correo = ? WHERE id = ?"
            val statement: PreparedStatement = conexion!!.prepareStatement(query)
            statement.setString(1, cliente.persona.nombre)
            statement.setInt(2, cliente.persona.celular)
            statement.setString(3, cliente.persona.direccion)
            statement.setString(4, cliente.persona.correo)
            statement.setString(5, cliente.persona.id)

            statement.executeUpdate() > 0
        } catch (e: SQLException) {
            println("Error al actualizar cliente: ${e.message}")
            false
        } finally {
            conexion?.close()
        }
    }

    fun eliminarCliente(id: String): Boolean {
        val conexion: Connection? = DatabaseConnection.getConnection()
        return try {
            val query = "DELETE FROM Clientes WHERE id = ?"
            val statement: PreparedStatement = conexion!!.prepareStatement(query)
            statement.setString(1, id)

            statement.executeUpdate() > 0
        } catch (e: SQLException) {
            println("Error al eliminar cliente: ${e.message}")
            false
        } finally {
            conexion?.close()
        }
    }
}