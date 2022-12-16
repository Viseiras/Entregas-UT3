package com.jvicedo.ut3.Entidades;

import jakarta.persistence.*;
import org.hibernate.sql.ast.tree.expression.AliasedExpression;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "alimentos")
public class Alimento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private int cantidad;
    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy="alimentos")
    private List<Cortahoja> hormigas;

    public Alimento( String nombre, int cantidad, List<Cortahoja> hormigas) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.hormigas = hormigas;
    }

    public Alimento() {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Cortahoja> getHormigas() {
        return hormigas;
    }

    public void setHormigas(List<Cortahoja> hormigas) {
        this.hormigas = hormigas;
    }

    @Override
    public String toString() {
        return "Alimento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", hormigas=" + hormigas +
                '}';
    }
}
