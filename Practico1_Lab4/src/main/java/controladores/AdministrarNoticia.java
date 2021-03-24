package controladores;

import entidades.Noticia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AdministrarNoticia {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    private EntityManagerFactory entityManagerFactory;

    public AdministrarNoticia(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("AppPU");
        this.entityManager = entityManagerFactory.createEntityManager();

    }

    public AdministrarNoticia(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = this.entityManager.getTransaction();
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

   /* public Noticia Buscar(int id) {
        return entityManager.find(Noticia.class, id);
    }

    public void Modificar(int id, @org.jetbrains.annotations.NotNull Noticia noticiaModificada) {
        beginTransaction();
        Noticia noticia = entityManager.find(Noticia.class, id);
        noticiaModificada.setId(noticia.getId());
        entityManager.merge(noticiaModificada);
        commitTransaction();
    }

    public void Baja(int id) {
        beginTransaction();
        Noticia noticia = entityManager.find(Noticia.class, id);
        entityManager.remove(noticia);
        commitTransaction();
    }

    public List<Noticia> Listar() {
        return entityManager.createQuery("SELECT a FROM Noticia a", Noticia.class).getResultList();
    }


    private void beginTransaction() {
        try {
            entityTransaction.begin();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    private void commitTransaction() {
        try {
            entityTransaction.commit();
            entityManager.close();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    private void rollbackTransaction() {
        try {
            entityTransaction.rollback();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    private void closeTransaction() {
        try {
            entityManager.close();
            entityManagerFactory.close();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }*/
}
