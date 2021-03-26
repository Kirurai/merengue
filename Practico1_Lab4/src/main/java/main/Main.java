package main;

import controladores.AdministrarEmpresa;
import controladores.AdministrarNoticia;
import entidades.Empresa;
import entidades.Noticia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){

        //Esto solo ejecutarlo para crear y llenar la base de datos

        Map<String, String> persistenceMap = new HashMap<>();

        persistenceMap.put("javax.persistence.schema-generation.database.action", "drop-and-create");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppPU", persistenceMap);
        EntityManager em = emf.createEntityManager();


            //iniciar transaccion
//            em.getTransaction().begin();
            //instrucciones

        AdministrarEmpresa administrarEmpresa= new AdministrarEmpresa(em);
        AdministrarNoticia administrarNoticia = new AdministrarNoticia(em);

        Empresa emp1 = new Empresa(
                "Empresa Dummy",
                "111111",
                "24h",
                "Somos una empresa dummy",
                8,9,
                "Calle falsa 123","ed@gmail.com");

        Empresa emp2 = new Empresa(
                "Tiburones",
                "654987",
                "12 a 6",
                "tiburones",
                7.456,95.596,
                "alla","w@w.com");

        Empresa emp3 = new Empresa(
                "Otra empresa",
                "212121",
                "2 a 8",
                "Somos otra empresa de calidad",
                102.1523,87.5668,
                "Al lado de la otra empresa","otra@empresa.com");

        Empresa emp4 = new Empresa(
                "La empresa",
                "226644",
                "24h",
                "Somos una empresa dedicada a ser la mejor empresa",
                7.22,9.42,
                "Aca","laempresa@hotmail.com");

        administrarEmpresa.Alta(emp1);
        administrarEmpresa.Alta(emp2);
        administrarEmpresa.Alta(emp3);
        administrarEmpresa.Alta(emp4);

        administrarNoticia.Alta(new Noticia(
                "Titulo de la noticia",
                "Resumen de la noticia",
                "Link de la imagen",
                "Contenido HTML",
                's',
                Date.valueOf("2021-03-20"),
                emp1
        ));

        administrarNoticia.Alta(new Noticia(
                "Titulo de la noticia",
                "Resumen de la noticia",
                "Link de la imagen",
                "Contenido HTML",
                's',
                Date.valueOf("2021-03-20"),
                emp1
        ));

        administrarNoticia.Alta(new Noticia(
                "Titulo de la noticia",
                "Resumen de la noticia",
                "Link de la imagen",
                "Contenido HTML",
                's',
                Date.valueOf("2021-03-20"),
                emp2
        ));


        //fin instrucciones

        //limpiar conexion
//            em.flush();

        //commit
//            em.getTransaction().commit();


        //cerrar conexion de em y emf
        em.close();
        emf.close();

    }



}
