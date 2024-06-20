/*
 * Este archivo define la clase Ciclo3_ModificarObjeto, que muestra cómo modificar un objeto JPA.
 * Se ilustra el ciclo de vida de la entidad desde ser encontrada, modificada y sincronizada nuevamente en la base de datos.
 */

/*
 * El paquete donde se encuentra la clase Ciclo3_ModificarObjeto.
 */
package com.colibri.testciclo;

/*
 * Importaciones necesarias para la clase Ciclo3_ModificarObjeto.
 */
import com.colibri.dao.GenericDAO; // Importa la clase GenericDAO del paquete com.colibri.dao.
import com.colibri.domain.Cliente; // Importa la clase Cliente del paquete com.colibri.domain.

import jakarta.persistence.EntityManager; // Importa la clase EntityManager de JPA para gestionar entidades.

/**
 * Clase principal para demostrar cómo modificar un objeto JPA.
 * Se muestra el ciclo de vida de la entidad desde ser encontrada,
 * modificada y sincronizada nuevamente en la base de datos.
 */
public class Ciclo3_ModificarObjeto extends GenericDAO {

    /*
     * Método principal que inicia la ejecución del programa.
     */
    public static void main(String[] args) {
        // Crear instancia de la clase para usar métodos no estáticos
        Ciclo3_ModificarObjeto ciclo = new Ciclo3_ModificarObjeto();

        // Llamar al método para modificar el cliente por ID
        ciclo.modificarClientePorId(6); // Pasa el ID que deseas modificar
    }

    /*
     * Método que muestra cómo modificar un cliente por su ID usando JPA.
     */
    public void modificarClientePorId(int id) {
        try {
            // Obtener EntityManager desde GenericDAO
            em = getEntityManager();

            // Estado Persistente: Recuperación de la entidad desde la base de datos
            // Buscar la entidad Cliente en la base de datos usando su ID
            Cliente cliente = em.find(Cliente.class, id);

            if (cliente != null) {
                // Modificación en memoria (la entidad ya está en estado persistente porque está gestionada por el EntityManager)
                // Cambiar el nombre, correo electrónico, teléfono y contraseña del cliente
                cliente.setNombre("Pedro");
                cliente.setCorreo_electronico("elpedrohe@gmail.com");
                cliente.setTelefono("44444");
                cliente.setContrasena("987654321");

                // Iniciar una transacción para realizar la actualización
                em.getTransaction().begin();

                // Estado Persistente en la Base de Datos:
                // Usar `merge` para sincronizar la entidad modificada con la base de datos
                em.merge(cliente);

                // Confirmar la transacción para guardar los cambios en la base de datos
                em.getTransaction().commit();

                // Mostrar la entidad Cliente con la información modificada
                System.out.println("cliente = " + cliente);
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
