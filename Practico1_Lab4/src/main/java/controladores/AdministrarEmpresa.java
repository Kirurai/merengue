package controladores;

import entidades.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class AdministrarEmpresa {

    private EntityManagerFactory entityManagerFactory;

    public AdministrarEmpresa() {
        try {
            this.entityManagerFactory = Persistence.createEntityManagerFactory("AppPU");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Alta(Empresa empresa) {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(empresa);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public Empresa Buscar(int id) {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Empresa.class, id);
        } finally {
            entityManager.close();
        }
    }

    public void Modificar(int id, @org.jetbrains.annotations.NotNull Empresa empresaModificada) {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Empresa empresa = entityManager.find(Empresa.class, id);
            empresaModificada.setId(empresa.getId());
            entityManager.merge(empresaModificada);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
     }

    public void Baja(int id) {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Empresa empresa = entityManager.find(Empresa.class, id);
            entityManager.remove(empresa);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public List<Empresa> Listar() {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT a FROM Empresa a", Empresa.class).getResultList();
        } finally {
            entityManager.close();
        }
    }


    public void cerrarEmf() {
        this.entityManagerFactory.close();
    }


}
