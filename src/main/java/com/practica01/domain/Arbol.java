
package com.practica01.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")

public class Arbol implements Serializable { //serializacion porque se va almacenar ciertos datos en el disco

    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la categoria.

    @Id //id categoria es la llave de la tabla categoria. 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD 
    @Column(name = "id_arbol") //decir cual es el nombre en la base de datos. Se hace la asociación 
    private long id_arbol;
    private String nombre_comun;
    private String rutaImagen;
    private String tipo_flor;
    private String dureza_madera;
    private boolean activo;

    public Arbol() {
    }

    public Arbol(String nombre_comun, boolean activo) {
        this.nombre_comun = nombre_comun;
        this.activo = activo;
    }

}
