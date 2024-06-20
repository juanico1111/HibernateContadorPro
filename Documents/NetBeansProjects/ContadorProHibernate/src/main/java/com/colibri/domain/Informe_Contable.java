/*
 * Este archivo define la clase Informe_Contable, que representa la entidad "informe contable" en la base de datos.
 * Utiliza anotaciones JPA para mapear la clase a una tabla de la base de datos y especificar detalles
 * como el nombre de la tabla, el nombre de las columnas y la estrategia de generación de identidad.
 */

/*
 * El paquete donde se encuentra la clase Informe_Contable.
 */
package com.colibri.domain;

/*
 * Importaciones necesarias para la clase Informe_Contable.
 */
import jakarta.persistence.Entity; // Importa la anotación Entity de JPA.
import jakarta.persistence.Id; // Importa la anotación Id de JPA.
import java.io.Serializable; // Importa la interfaz Serializable para permitir la serialización.

/**
 * Clase que representa la entidad "informe contable" en la base de datos.
 */
@Entity // Indica que esta clase es una entidad JPA.
public class Informe_Contable implements Serializable {
    
    @Id // Indica que este atributo es la clave primaria.
    private int id_informe_contable; // Atributo que representa el ID del informe contable.
    
    private String nombre; // Atributo que representa el nombre del informe contable.
    
    private String fecha_creacion; // Atributo que representa la fecha de creación del informe contable.
    
    private String contenido; // Atributo que representa el contenido del informe contable.
    
    private String estado; // Atributo que representa el estado del informe contable.

    /*
     * Constructor sin argumentos necesario para JPA.
     */
    public Informe_Contable() {
    }

    /*
     * Constructor que inicializa el ID del informe contable.
     */
    public Informe_Contable(int id_informe_contable) {
        this.id_informe_contable = id_informe_contable;
    }

    /*
     * Métodos getters y setters para acceder y modificar los atributos privados de la clase.
     */
    public int getId_informe_contable() {
        return id_informe_contable;
    }

    public void setId_informe_contable(int id_informe_contable) {
        this.id_informe_contable = id_informe_contable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /*
     * Método toString para representar el objeto Informe_Contable como una cadena de texto.
     */
    @Override
    public String toString() {
        return "Informe_Contable{" +
                "id_informe_contable=" + id_informe_contable +
                ", nombre=" + nombre +
                ", fecha_creacion=" + fecha_creacion +
                ", contenido=" + contenido +
                ", estado=" + estado +
                '}';
    }

    /*
     * Método hashCode para calcular el código hash del objeto basado en el ID del informe contable.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_informe_contable;
        return result;
    }

    /*
     * Método equals para comparar dos objetos Informe_Contable basado en el ID del informe contable.
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
        Informe_Contable other = (Informe_Contable) obj;
        return this.id_informe_contable == other.id_informe_contable;
    }
}
