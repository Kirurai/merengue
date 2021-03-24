package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppPU");
        EntityManager em = emf.createEntityManager();

        try {
            //iniciar transaccion
            em.getTransaction().begin();
            em.setProperty("javax.persistence.schema-generation.database.action", "none");
            //instrucciones


            //fin instrucciones

            //limpiar conexion
            em.flush();

            //commit
            em.getTransaction().commit();


        }catch (Exception e){

            //rollback
            em.getTransaction().rollback();

        }

        //cerrar conexion de em y emf
        em.close();
        emf.close();

    }
}
