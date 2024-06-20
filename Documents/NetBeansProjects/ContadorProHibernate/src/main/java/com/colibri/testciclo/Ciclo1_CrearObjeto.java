/*
 * Este archivo define la clase Ciclo1_CrearObjeto, que muestra el ciclo de vida de una entidad JPA (Cliente).
 * Se ilustra cómo crear, persistir y separar una entidad usando JPA.
 */

/*
 * El paquete donde se encuentra la clase Ciclo1_CrearObjeto.
 */
package com.colibri.testciclo;

/*
 * Importaciones necesarias para la clase Ciclo1_CrearObjeto.
 */
import com.colibri.dao.GenericDAO; // Importa la clase GenericDAO del paquete com.colibri.dao.
import com.colibri.domain.Cliente; // Importa la clase Cliente del paquete com.colibri.domain.

import jakarta.persistence.EntityManager; // Importa la clase EntityManager de JPA para gestionar entidades.

/**
 * Clase principal para demostrar el ciclo de vida de una entidad JPA (Cliente).
 * Se muestra cómo crear, persistir y separar una entidad usando JPA.
 */
public class Ciclo1_CrearObjeto extends GenericDAO {

    /*
     * Método principal que inicia la ejecución del programa.
     */
    public static void main(String[] args) {
        // Crear instancia de la clase para usar métodos no estáticos
        Ciclo1_CrearObjeto ciclo = new Ciclo1_CrearObjeto();

        ciclo.persistirCliente(); // Llama al método persistirCliente() para demostrar el ciclo de vida de Cliente.
    }

    /*
     * Método que demuestra el ciclo de vida de la entidad Cliente.
     */
    public void persistirCliente() {
        // Estado 1: Transitorio
        // Crear una nueva instancia de la entidad Cliente
        Cliente cliente = new Cliente();

        // Asignar valores a los atributos del cliente
        cliente.setNombre("Laura");
        cliente.setCorreo_electronico("lau@gmail.com");
        cliente.setTelefono("3124785964");
        cliente.setContrasena("lau14589763");

        // Estado 2: Persistente
        try {
            // Obtener EntityManager
            em = getEntityManager();

            // Iniciar una transacción
            em.getTransaction().begin();

            // Persistir la instancia de Cliente
            em.persist(cliente);

            // Confirmar la transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out); // Imprimir la traza de la excepción en caso de error
        } finally {
            // Cerrar el EntityManager en el bloque finally para asegurar que siempre se cierre correctamente
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

        // Estado 3: Separado
        System.out.println("cliente = " + cliente); // Imprimir la representación del objeto Cliente

        // Cerrar la fábrica de EntityManagers
        closeEntityManagerFactory();
    }
}
