package com.jvicedo.ut3.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue(value = "C")
@Table(name = "cortahojas")
public class Cortahoja extends Hormiga{

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="FK_vpn",referencedColumnName = "id")
    private Vpn vpn;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "hormiga-alimento", joinColumns = {@JoinColumn(name = "FK_hormiga",referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "FK_alimento",referencedColumnName = "id")})
    private List<Alimento> alimentos;

    public Cortahoja(int patas, String nombre, Colonia colonia, List<Alimento> alimentos,  Vpn vpn) {
        super(patas, nombre, colonia);
        this.alimentos = alimentos;
        this.vpn = vpn;
    }

    public Cortahoja() {
    }

    public void setAlimento(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    public Vpn getVpn() {
        return vpn;
    }

    public void setVpn(Vpn vpn) {
        this.vpn = vpn;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }
}
