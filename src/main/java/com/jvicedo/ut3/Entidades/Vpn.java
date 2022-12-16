package com.jvicedo.ut3.Entidades;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="VPN")
public class Vpn implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private int paisesdisponibles;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Cortahoja hormiga;

    public Vpn() {
    }

    public Vpn(String nombre, int paisesdisponibles, Cortahoja hormiga) {
        this.nombre = nombre;
        this.paisesdisponibles = paisesdisponibles;
        this.hormiga = hormiga;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPaisesdisponibles() {
        return paisesdisponibles;
    }

    public void setPaisesdisponibles(int paisesdisponibles) {
        this.paisesdisponibles = paisesdisponibles;
    }

    public Cortahoja getHormiga() {
        return hormiga;
    }

    public void setHormiga(Cortahoja hormiga) {
        this.hormiga = hormiga;
    }

    @Override
    public String toString() {
        return "Vpn{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", paisesdisponibles=" + paisesdisponibles +
                ", hormiga=" + hormiga +
                '}';
    }
}
