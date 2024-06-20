/*
 * Este archivo define una clase de prueba para probar el funcionamiento de la clase ClienteDAO,
 * específicamente el método mostrar(), que recupera y muestra una lista de clientes.
 */

/*
 * El paquete donde se encuentra la clase Test.
 */
package com.colibri.test;

/*
 * Importaciones necesarias para la clase Test.
 */
import com.colibri.dao.ClienteDAO; // Importa la clase ClienteDAO del paquete com.colibri.dao.
import java.util.List; // Importa la interfaz List del paquete java.util para trabajar con colecciones.

/**
 * Clase de prueba para probar el funcionamiento de la clase ClienteDAO.
 */
public class Test {

    /*
     * Método principal que inicia la ejecución del programa.
     */
    public static void main(String[] args) {
        Test test = new Test(); // Crea una instancia de la clase Test.
        test.pruebaMostrar(); // Llama al método pruebaMostrar() para probar el método mostrar() de ClienteDAO.
    }

    /*
     * Método que prueba el método mostrar() de ClienteDAO.
     */
    public void pruebaMostrar() {
        ClienteDAO clienteDao = new ClienteDAO(); // Crea una instancia de ClienteDAO para acceder a sus métodos.
        System.out.println("________________________Clientes___________________________");
        imprimir(clienteDao.mostrar()); // Llama al método mostrar() de ClienteDAO y luego imprime los resultados.
    }

    /*
     * Método privado estático que imprime una colección de objetos.
     */
    private static void imprimir(List coleccion) {
        for (Object o : coleccion) { // Itera sobre cada objeto en la colección.
            System.out.println("Clientes: " + o); // Imprime cada objeto en la colección.
        }
    }
}
