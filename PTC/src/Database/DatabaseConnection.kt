package Database

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DatabaseConnection {
    private const val URL = "jdbc:sqlserver://localhost\\mssqllocaldb;databaseName=PTC_Kotlin;integratedSecurity=true;encrypt=false"

    fun getConnection(): Connection? {
        return try {
            DriverManager.getConnection(URL).apply {
                println("Conexión exitosa a SQL Server.")
            }
        } catch (e: SQLException) {
            println("Error al conectar a la base de datos: ${e.message}")
            null
        }
    }
}
