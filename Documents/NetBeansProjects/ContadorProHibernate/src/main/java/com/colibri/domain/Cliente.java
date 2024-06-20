/*
 * Este archivo define la clase Cliente, que representa la entidad "cliente" en la base de datos.
 * Utiliza anotaciones JPA para mapear la clase a una tabla de la base de datos y especificar detalles
 * como el nombre de la tabla, el nombre de las columnas y la estrategia de generación de identidad.
 */

/*
 * El paquete donde se encuentra la clase Cliente.
 */
package com.colibri.domain;

/*
 * Importaciones necesarias para la clase Cliente.
 */
import jakarta.persistence.*; // Importa las anotaciones y clases de JPA.
import java.io.Serializable; // Importa la interfaz Serializable para permitir la serialización.

/**
 * Clase que representa la entidad "cliente" en la base de datos.
 */
@Entity // Indica que esta clase es una entidad JPA.
@Table(name = "cliente") // Especifica el nombre de la tabla en la base de datos.
public class Cliente implements Serializable {
    
    @Id // Indica que este atributo es la clave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia de generación de la clave primaria.
    @Column(name = "id_cliente") // Nombre de la columna en la tabla.
    private int id_cliente; // Atributo que representa el ID del cliente.
    
    private String nombre; // Atributo que representa el nombre del cliente.
    
    @Column(name = "correo_electronico") // Nombre de la columna en la tabla.
    private String correo_electronico; // Atributo que representa el correo electrónico del cliente.
    
    private String telefono; // Atributo que representa el teléfono del cliente.
    
    private String contrasena; // Atributo que representa la contraseña del cliente.
    
    /*
     * Constructor sin argumentos necesario para JPA.
     */
    public Cliente() {
    }

    /*
     * Constructor que inicializa el ID del cliente.
     */
    public Cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /*
     * Métodos getters y setters para acceder y modificar los atributos privados de la clase.
     */
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /*
     * Método toString para representar el objeto Cliente como una cadena de texto.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", nombre='" + nombre + '\'' +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", telefono='" + telefono + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }

    /*
     * Método hashCode para calcular el código hash del objeto basado en el ID del cliente.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_cliente;
        return result;
    }

    /*
     * Método equals para comparar dos objetos Cliente basado en el ID del cliente.
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
        Cliente other = (Cliente) obj;
        return id_cliente == other.id_cliente;
    }

}
