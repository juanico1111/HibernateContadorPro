/*
 * Este archivo define la clase Ciclo2_ObtenerObjeto, que muestra cómo obtener un objeto JPA desde la base de datos.
 * Se ilustra el uso de EntityManager para encontrar una entidad por su ID.
 */

/*
 * El paquete donde se encuentra la clase Ciclo2_ObtenerObjeto.
 */
package com.colibri.testciclo;

/*
 * Importaciones necesarias para la clase Ciclo2_ObtenerObjeto.
 */
import com.colibri.dao.GenericDAO; // Importa la clase GenericDAO del paquete com.colibri.dao.
import com.colibri.domain.Cliente; // Importa la clase Cliente del paquete com.colibri.domain.

import jakarta.persistence.EntityManager; // Importa la clase EntityManager de JPA para gestionar entidades.

/**
 * Clase principal para demostrar cómo obtener un objeto JPA desde la base de datos.
 * Se muestra el uso de EntityManager para encontrar una entidad por su ID.
 */
public class Ciclo2_ObtenerObjeto extends GenericDAO {

    /*
     * Método principal que inicia la ejecución del programa.
     */
    public static void main(String[] args) {
        // Crear instancia de la clase para usar métodos no estáticos
        Ciclo2_ObtenerObjeto ciclo = new Ciclo2_ObtenerObjeto();

        ciclo.obtenerClientePorId(7); // Llama al método obtenerClientePorId() con el ID deseado
    }

    /*
     * Método que muestra cómo obtener un cliente por su ID usando JPA.
     */
    public void obtenerClientePorId(int id) {
        em = null; // Inicializa el EntityManager como nulo
        try {
            // Obtener EntityManager desde GenericDAO
            em = getEntityManager();

            // Buscar la entidad Cliente en la base de datos usando su ID
            Cliente cliente = em.find(Cliente.class, id);

            // Mostrar la entidad Cliente encontrada
            if (cliente != null) {
                System.out.println("contacto: " + cliente);
            } else {
                System.out.println("No se encontró un cliente con el ID especificado.");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out); // Imprime la traza de la excepción en caso de error
        } finally {
            // Cerrar el EntityManager usando el método de GenericDAO
            if (em != null && em.isOpen()) {
                em.close();
            }
            closeEntityManagerFactory(); // Cierra la fábrica de EntityManagers al finalizar
        }
    }
}
