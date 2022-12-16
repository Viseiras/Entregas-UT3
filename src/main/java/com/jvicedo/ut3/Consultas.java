package com.jvicedo.ut3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Objects;

public class Consultas {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();


        //Seleccionamos todos los nombres de las hormigas
        System.out.println("-----QUERY 1-----");
        String hql = "select id, nombre from Hormiga";
        Query query = ss.createQuery(hql);
        List<Object[]> result = query.getResultList();

        for(Object[] o:result)
        {
            System.out.println("La hormiga con id "+o[0]+" se llama "+o[1]);
        }
        System.out.println("-----------------");
        //Seleccionamos todas las hormigas que sean cortahoja
        System.out.println("-----QUERY 2-----");

        hql = "select H.id, H.nombre from Hormiga H, Cortahoja C where H.class=C.class and H.id=C.id";
        Query query2 = ss.createQuery(hql);
        List<Object[]> result2 = query2.getResultList();

        for(Object[] o:result2)
        {
            System.out.println("La hormiga con id "+o[0]+" se llama "+o[1]+" y es Cortahoja");
        }

        System.out.println("-----------------");
        //Seleccionamos todas las hormigas de una colonia
        System.out.println("-----QUERY 3-----");
        hql = "select H.id, H.nombre, C.nombre from Hormiga H, Colonia C where H.colonia=C.id";
        Query query3 = ss.createQuery(hql);
        List<Object[]> result3 = query3.getResultList();
        for(Object[] o:result3)
        {
            System.out.println("La hormiga con id "+o[0]+" se llama "+o[1]+" y pertenece a la colonia "+o[2]);
        }

        System.out.println("-----------------");
        //Seleccionamos todas las hormigas y sus VPN
        System.out.println("-----QUERY 4-----");
        hql = "select C.id, C.nombre, V.nombre from Cortahoja C, Vpn V where V.id=C.vpn";
        Query query4 = ss.createQuery(hql);
        List<Object[]> result4 = query4.getResultList();
        for(Object[] o:result4)
        {
            System.out.println("La hormiga con id "+o[0]+" se llama "+o[1]+" y su VPN de confianza es: "+o[2]);
        }

        System.out.println("-----------------");
        //Seleccionamos que come cada hormiga
        System.out.println("-----QUERY 5-----");
        hql = "FROM Cortahoja WHERE id = (:condicion) AND pass =(:condicion2)";
        Query query5 = ss.createQuery(hql);
        List<Object[]> result5 = query5.getResultList();
        for(Object[] o:result5)
        {
            System.out.println("La hormiga con id "+o[0]+" se llama "+o[1]+" y su VPN de confianza es: "+o[2]);
        }
    }
}
