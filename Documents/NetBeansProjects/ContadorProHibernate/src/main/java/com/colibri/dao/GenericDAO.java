/*
 * Este archivo define la clase abstracta GenericDAO, que proporciona métodos comunes
 * para interactuar con la base de datos utilizando JPA (Java Persistence API).
 */

/*
 * El paquete donde se encuentra la clase GenericDAO.
 */
package com.colibri.dao;

/*
 * Importaciones necesarias para la clase GenericDAO.
 */
import jakarta.persistence.*; // Importa las clases relacionadas con JPA.

/*
 * Definición de la clase abstracta GenericDAO.
 */
public abstract class GenericDAO {

    /*
     * EntityManager estático compartido entre todas las instancias de GenericDAO.
     */
    protected static EntityManager em;

    /*
     * EntityManagerFactory estática para crear EntityManagers.
     */
    private static EntityManagerFactory emf;

    /*
     * Nombre de la unidad de persistencia configurada en persistence.xml.
     */
    private static final String PU = "contadorpro";

    /*
     * Constructor de GenericDAO que inicializa EntityManagerFactory si no está inicializado.
     */
    public GenericDAO() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PU); // Crea EntityManagerFactory.
        }
    }

    /*
     * Método protegido para obtener un EntityManager.
     * Crea uno si no existe o está cerrado.
     */
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = emf.createEntityManager(); // Crea un nuevo EntityManager.
        }
        return em;
    }

    /*
     * Método protegido para cerrar el EntityManager actual.
     */
    protected void closeEntityManager() {
        if (em != null && em.isOpen()) {
            em.close(); // Cierra el EntityManager si está abierto.
        }
    }

    /*
     * Método protegido para cerrar la EntityManagerFactory.
     */
    protected void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close(); // Cierra la EntityManagerFactory si está abierta.
        }
    }
}
