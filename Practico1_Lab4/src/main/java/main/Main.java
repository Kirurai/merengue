package main;

import controladores.AdministrarEmpresa;
import entidades.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        Map<String, String> persistenceMap = new HashMap<>();

        persistenceMap.put("javax.persistence.schema-generation.database.action", "none");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppPU", persistenceMap);
        EntityManager em = emf.createEntityManager();

        try {
            //iniciar transaccion
            em.getTransaction().begin();
            em.setProperty("javax.persistence.schema-generation.database.action", "create");
            //instrucciones


            //Prueba AdministradorEmpresa
            AdministrarEmpresa administrarEmpresa= new AdministrarEmpresa(em);

            administrarEmpresa.Alta(new Empresa("Tiburones",
                    "654987",
                    "24h",
                    "tiburones",
                    8,9,
                    "alla","w@w"));
            System.out.println("empresa Tiburones agregada");

            Empresa empresaDummy = administrarEmpresa.Buscar(1);
            System.out.println("empresa encontrada con id=1:" + empresaDummy.getDenominacion());

            empresaDummy.setDenominacion("fafafa");
            administrarEmpresa.Modificar(1,empresaDummy);
            System.out.println("empresa encontrada con id=1 modificada");


            System.out.println("-----Lista de empresas------");
            List<Empresa> ListaDeEmpresas;
            ListaDeEmpresas=administrarEmpresa.Listar();

            for (Empresa e:ListaDeEmpresas) {
                System.out.println(e.getDenominacion());
            }
            //FIN Prueba AdministradorEmpresa


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
