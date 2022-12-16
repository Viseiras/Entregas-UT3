package com.jvicedo.ut3.Entidades;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@DiscriminatorColumn(name="especie",discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue(value = "H")
public class Hormiga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int patas;
    @Column
    private String nombre;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_colonia",referencedColumnName = "id")
    private Colonia colonia;

    public Hormiga(int patas,String nombre,Colonia colonia) {
        this.patas = patas;
        this.nombre = nombre;
        this.colonia = colonia;
    }

    public Hormiga() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatas() {
        return patas;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Colonia getColonia() {
        return colonia;
    }

    public void setColonia(Colonia colonia) {
        this.colonia = colonia;
    }

    @Override
    public String toString() {
        return "bicho{" +
                "id=" + id +
                ", patas=" + patas +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
