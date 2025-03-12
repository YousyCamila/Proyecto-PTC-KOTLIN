package menusPrincipal

import Administrador.Casos.MenuCaso
import Administrador.Clientes.ClienteMenu
import Administrador.Detectives.DetectiveMenu
import ClientesEvidencia.EvidenciaMenu
import DetectivesControladorEvidencia.ControladorEvidencia.ControladorEvidencia
import java.util.Scanner


class MenuPrincipal {

    fun llamarMenu() {

        val evidenciaMenu = EvidenciaMenu()
        val controladorEvidencia = ControladorEvidencia()
        val clienteMenu = ClienteMenu()
        val detectiveMenu = DetectiveMenu()

        println("=== Menú Principal ===")
        println("1. Gestionar Casos de Administrador")
        println("2. Gestionar Evidencias")
        println("3. Gestionar Clientes ")
        println("4. Gestionar Detectives")
        println("5. Salir")
        print("Seleccione una opción: ")

        when (readln().trim()) {
            "1" -> {
                // Llamar al menú de casos
                MenuCaso()
            }
            "2" -> {
                // Llamar al CRUD de evidencias

                controladorEvidencia.iniciar()
            }
            "3" -> {

                clienteMenu.MenuDeCliente()
            }
            "4" ->{
                detectiveMenu.MenuDeDetectives()
            }
            "5" -> {
                println("Saliendo del sistema...")
            }
            else -> {
                println("Opción inválida. Intente de nuevo.")
            }
        }
        val scanner = Scanner(System.`in`)


        while (true) {
            println("\n=== Menú Principal ===")
            println("1. Gestionar Administrador.Casos")
            println("2. Gestionar Evidencias")
            println("3. Gestionar Clientes")
            println("4. Gestionar Detectives")
            println("5. Salir")
            print("Seleccione una opción: ")

            when (scanner.nextInt()) {
                1 -> evidenciaMenu.gestionarCasos()
                2 -> controladorEvidencia.iniciar()
                3 -> clienteMenu.MenuDeCliente()
                4 -> detectiveMenu.MenuDeDetectives()
                5 -> {
                    println("Saliendo del sistema...")
                    return
                }
                else -> println("Opción inválida, intente de nuevo.")
            }
        }
    }
    fun menuAdministrador(){

    }
    fun menuDetective(){

    }
    fun menuCliente(){

    }
}