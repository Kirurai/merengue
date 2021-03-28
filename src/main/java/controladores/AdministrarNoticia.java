package controladores;

import entidades.Noticia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AdministrarNoticia {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public AdministrarNoticia(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("AppPU");
        this.entityManager = entityManagerFactory.createEntityManager();

    }

    public AdministrarNoticia(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void Alta(Noticia noticia) {

        try{
            entityManager.getTransaction().begin();
            entityManager.persist(noticia);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
//        entityManager.close();
//        entityManagerFactory.close();

    }

   public Noticia Buscar(int id) {
        return entityManager.find(Noticia.class, id);
    }

    public void Modificar(int id, Noticia noticiaModificada) {
        try{
            entityManager.getTransaction().begin();
            Noticia noticia = entityManager.find(Noticia.class, id);
            noticiaModificada.setId(noticia.getId());
            entityManager.merge(noticiaModificada);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void Baja(int id) {
        try{
            entityManager.getTransaction().begin();
            Noticia noticia = entityManager.find(Noticia.class, id);
            entityManager.remove(noticia);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }

    }

    public List<Noticia> Listar() {
        return entityManager.createQuery("SELECT a FROM Noticia a", Noticia.class).getResultList();
    }

}
