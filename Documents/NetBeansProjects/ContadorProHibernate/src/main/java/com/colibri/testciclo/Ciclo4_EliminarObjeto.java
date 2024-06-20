/*
 * Este archivo define la clase Ciclo4_EliminarObjeto, que muestra cómo eliminar un objeto JPA de la base de datos.
 * Se ilustra el ciclo de vida de la entidad desde ser encontrada, gestionada y luego eliminada de la base de datos.
 */

/*
 * El paquete donde se encuentra la clase Ciclo4_EliminarObjeto.
 */
package com.colibri.testciclo;

/*
 * Importaciones necesarias para la clase Ciclo4_EliminarObjeto.
 */
import com.colibri.dao.GenericDAO; // Importa la clase GenericDAO del paquete com.colibri.dao.
import com.colibri.domain.Cliente; // Importa la clase Cliente del paquete com.colibri.domain.

import jakarta.persistence.EntityManager; // Importa la clase EntityManager de JPA para gestionar entidades.

/**
 * Clase principal para demostrar cómo eliminar un objeto JPA de la base de datos.
 * Se muestra el ciclo de vida de la entidad desde ser encontrada,
 * gestionada y luego eliminada de la base de datos.
 */
public class Ciclo4_EliminarObjeto extends GenericDAO {

    /*
     * Método principal que inicia la ejecución del programa.
     */
    public static void main(String[] args) {
        // Crear instancia de la clase para usar métodos no estáticos
        Ciclo4_EliminarObjeto ciclo = new Ciclo4_EliminarObjeto();

        // Llamar al método para eliminar el cliente por ID
        ciclo.eliminarClientePorId(5); // Pasa el ID que deseas eliminar
    }

    /*
     * Método que muestra cómo eliminar un cliente por su ID usando JPA.
     */
    public void eliminarClientePorId(int id) {
        em = null;
        try {
            // Obtener EntityManager desde GenericDAO
            em = getEntityManager();

            // Estado Persistente: Recuperación de la entidad desde la base de datos
            Cliente cliente = em.find(Cliente.class, id);

            if (cliente != null) {
                // Iniciar una transacción para realizar la eliminación
                em.getTransaction().begin();

                // Estado Persistente en la Base de Datos:
                // Usar `remove` para eliminar la entidad de la base de datos.
                // Asegurar que la entidad esté en el contexto de persistencia en caso de que no lo esté ya.
                em.remove(em.merge(cliente));

                // Confirmar la transacción para eliminar la entidad de la base de datos
                em.getTransaction().commit();

                // Mostrar la entidad Cliente eliminada
                System.out.println("Datos eliminados = " + cliente);
            } else {
                System.out.println("No se encontró un cliente con el ID especificado.");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out); // Imprime la traza de la excepción en caso de error
        } finally {
            // Cerrar el EntityManager para liberar recursos
            if (em != null && em.isOpen()) {
                em.close();
            }
            closeEntityManagerFactory(); // Cierra la fábrica de EntityManagers al finalizar
        }
    }
}
