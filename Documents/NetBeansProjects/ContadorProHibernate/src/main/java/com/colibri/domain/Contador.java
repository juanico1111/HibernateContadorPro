/*
 * Este archivo define la clase Contador, que representa la entidad "contador" en la base de datos.
 * Utiliza anotaciones JPA para mapear la clase a una tabla de la base de datos y especificar detalles
 * como el nombre de la tabla, el nombre de las columnas y la estrategia de generación de identidad.
 */

/*
 * El paquete donde se encuentra la clase Contador.
 */
package com.colibri.domain;

/*
 * Importaciones necesarias para la clase Contador.
 */
import jakarta.persistence.Entity; // Importa la anotación Entity de JPA.
import jakarta.persistence.Id; // Importa la anotación Id de JPA.
import java.io.Serializable; // Importa la interfaz Serializable para permitir la serialización.

/**
 * Clase que representa la entidad "contador" en la base de datos.
 */
@Entity // Indica que esta clase es una entidad JPA.
public class Contador implements Serializable {
    
    @Id // Indica que este atributo es la clave primaria.
    private int id_contador; // Atributo que representa el ID del contador.
    
    private String nombre; // Atributo que representa el nombre del contador.
    
    private String correo_electronico; // Atributo que representa el correo electrónico del contador.
    
    private String telefono; // Atributo que representa el teléfono del contador.
    
    private String contraseña; // Atributo que representa la contraseña del contador.

    /*
     * Constructor sin argumentos necesario para JPA.
     */
    public Contador() {
    }

    /*
     * Constructor que inicializa el ID del contador.
     */
    public Contador(int id_contador) {
        this.id_contador = id_contador;
    }

    /*
     * Métodos getters y setters para acceder y modificar los atributos privados de la clase.
     */
    public int getId_contador() {
        return id_contador;
    }

    public void setId_contador(int id_contador) {
        this.id_contador = id_contador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /*
     * Método toString para representar el objeto Contador como una cadena de texto.
     */
    @Override
    public String toString() {
        return "Contador{" +
                "id_contador=" + id_contador +
                ", nombre='" + nombre + '\'' +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", telefono='" + telefono + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }

    /*
     * Método hashCode para calcular el código hash del objeto basado en el ID del contador.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_contador;
        return result;
    }

    /*
     * Método equals para comparar dos objetos Contador basado en el ID del contador.
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
        Contador other = (Contador) obj;
        return id_contador == other.id_contador;
    }
}
