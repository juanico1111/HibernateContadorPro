/*
 * Este archivo define la clase Documento, que representa la entidad "documento" en la base de datos.
 * Utiliza anotaciones JPA para mapear la clase a una tabla de la base de datos y especificar detalles
 * como el nombre de la tabla, el nombre de las columnas y la estrategia de generación de identidad.
 */

/*
 * El paquete donde se encuentra la clase Documento.
 */
package com.colibri.domain;

/*
 * Importaciones necesarias para la clase Documento.
 */
import jakarta.persistence.Entity; // Importa la anotación Entity de JPA.
import jakarta.persistence.Id; // Importa la anotación Id de JPA.
import java.io.Serializable; // Importa la interfaz Serializable para permitir la serialización.

/**
 * Clase que representa la entidad "documento" en la base de datos.
 */
@Entity // Indica que esta clase es una entidad JPA.
public class Documento implements Serializable {
    
    @Id // Indica que este atributo es la clave primaria.
    private int id_documento; // Atributo que representa el ID del documento.
    
    private String tipo; // Atributo que representa el tipo de documento.
    
    private String nombre; // Atributo que representa el nombre del documento.
    
    private String fecha_creación; // Atributo que representa la fecha de creación del documento.

    /*
     * Constructor sin argumentos necesario para JPA.
     */
    public Documento() {
    }

    /*
     * Constructor que inicializa el ID del documento.
     */
    public Documento(int id_documento) {
        this.id_documento = id_documento;
    }

    /*
     * Métodos getters y setters para acceder y modificar los atributos privados de la clase.
     */
    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_creación() {
        return fecha_creación;
    }

    public void setFecha_creación(String fecha_creación) {
        this.fecha_creación = fecha_creación;
    }

    /*
     * Método toString para representar el objeto Documento como una cadena de texto.
     */
    @Override
    public String toString() {
        return "Documento{" +
                "id_documento=" + id_documento +
                ", tipo=" + tipo +
                ", nombre=" + nombre +
                ", fecha_creación=" + fecha_creación +
                '}';
    }

    /*
     * Método hashCode para calcular el código hash del objeto basado en el ID del documento.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_documento;
        return result;
    }

    /*
     * Método equals para comparar dos objetos Documento basado en el ID del documento.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Documento other = (Documento) obj;
        return this.id_documento == other.id_documento;
    }
}
