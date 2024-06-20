/*
 * Este archivo Java representa un DAO (Data Access Object) para la entidad Cliente.
 * Proporciona métodos para interactuar con la base de datos, incluyendo consultas,
 * inserciones, modificaciones y eliminaciones de clientes.
 */

/*
 * El paquete donde se encuentra la clase ClienteDAO.
 */
package com.colibri.dao;

/*
 * Importaciones necesarias para la clase ClienteDAO.
 */
import java.util.List; // Importa la interfaz List para trabajar con colecciones de objetos.
import com.colibri.domain.Cliente; // Importa la clase Cliente del paquete com.colibri.domain.
import jakarta.persistence.Query; // Importa la clase Query de Jakarta Persistence API.

/*
 * Definición de la clase ClienteDAO que extiende de GenericDAO.
 */
public class ClienteDAO extends GenericDAO {
    
    /*
     * Método para obtener una lista de todos los clientes almacenados en la base de datos.
     * Utiliza JPQL (Java Persistence Query Language) para realizar la consulta.
     */
    public List<Cliente> mostrar() {
        String consulta = "SELECT a FROM Cliente a"; // Consulta JPQL para seleccionar todos los clientes.
        em = getEntityManager(); // Obtiene el EntityManager.
        Query query = em.createQuery(consulta); // Crea la consulta utilizando el EntityManager.
        return query.getResultList(); // Ejecuta la consulta y retorna la lista de resultados.
    }
    
    /*
     * Método para ingresar un nuevo cliente en la base de datos.
     */
    public void Ingresar(Cliente cliente) {
        try {
            em = getEntityManager(); // Obtiene el EntityManager.
            em.getTransaction().begin(); // Inicia la transacción.
            em.persist(cliente); // Persiste el cliente en la base de datos.
            em.getTransaction().commit(); // Confirma la transacción.
        } catch (Exception e) {
            e.printStackTrace(System.out); // Imprime el stack trace si ocurre una excepción.
        } finally {
            if (em != null) {
                em.close(); // Cierra el EntityManager en el bloque finally.
            }
        }
    }
    
    /*
     * Método para modificar un cliente existente en la base de datos.
     */
    public void Modificar(Cliente cliente) {
        try {
            em = getEntityManager(); // Obtiene el EntityManager.
            em.getTransaction().begin(); // Inicia la transacción.
            em.merge(cliente); // Actualiza el cliente en la base de datos.
            em.getTransaction().commit(); // Confirma la transacción.
        } catch (Exception e) {
            e.printStackTrace(System.out); // Imprime el stack trace si ocurre una excepción.
        } finally {
            if (em != null) {
                em.close(); // Cierra el EntityManager en el bloque finally.
            }
        }
    }
    
    /*
     * Método para eliminar un cliente existente de la base de datos.
     */
    public void Eliminar(Cliente cliente) {
        try {
            em = getEntityManager(); // Obtiene el EntityManager.
            em.getTransaction().begin(); // Inicia la transacción.
            em.remove(em.merge(cliente)); // Elimina el cliente de la base de datos.
            em.getTransaction().commit(); // Confirma la transacción.
        } catch (Exception e) {
            e.printStackTrace(System.out); // Imprime el stack trace si ocurre una excepción.
        } finally {
            if (em != null) {
                em.close(); // Cierra el EntityManager en el bloque finally.
            }
        }
    }
    
    /*
     * Método para buscar un cliente por su ID en la base de datos.
     */
    public Object buscarPorID(Cliente cliente) {
        em = getEntityManager(); // Obtiene el EntityManager.
        return em.find(Cliente.class, cliente.getId_cliente()); // Busca el cliente por su ID y lo retorna.
    }
}
