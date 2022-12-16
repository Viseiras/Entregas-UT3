package com.jvicedo.ut3;

import com.jvicedo.ut3.Entidades.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class PersisteHormigas {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        Vpn NordVpn = new Vpn("NordVpn",15,null);
        Vpn Karspersky = new Vpn("Karspersky",125,null);
        Vpn Ghost = new Vpn("Ghost",15,null);

        Hormiga Paca = new Hormiga(6,"Paca",null);
        Hormiga Diego = new Hormiga(3,"Diego",null);
        Cortahoja Nunod = new Cortahoja(7,"Nuno",null,null,NordVpn);
        Cortahoja Alberto = new Cortahoja(4,"Alberto",null,null,Karspersky);
        Cortahoja Travis = new Cortahoja(9,"Travis",null,null,Ghost);
        NordVpn.setHormiga(Nunod);Karspersky.setHormiga(Alberto);Ghost.setHormiga(Travis);

        Nunod.setVpn(NordVpn);Alberto.setVpn(Karspersky);Travis.setVpn(Ghost);

        List<Hormiga> hormigas = new ArrayList<>();
        hormigas.add(Diego);hormigas.add(Paca);hormigas.add(Alberto);hormigas.add(Nunod);hormigas.add(Travis);

        List<Cortahoja> hormigasC = new ArrayList<>();
        hormigasC.add(Alberto);hormigasC.add(Nunod);hormigasC.add(Travis);

        Alimento patata = new Alimento("Patata",500,hormigasC);
        Alimento hoja_perenne = new Alimento("Perenne",1200,hormigasC);

        List<Alimento> alimentos = new ArrayList<>();
        alimentos.add(patata);alimentos.add(hoja_perenne);

        Nunod.setAlimento(alimentos);Alberto.setAlimento(alimentos);Travis.setAlimento(alimentos);

        Colonia hormiguero = new Colonia("HormiGOD",2000,hormigas);

        Nunod.setColonia(hormiguero);Alberto.setColonia(hormiguero);Travis.setColonia(hormiguero);Paca.setColonia(hormiguero);Diego.setColonia(hormiguero);

        for(Hormiga h: hormigas)
        {
            ss.persist(h);
        }
        t.commit();
        ss.close();
    }
}