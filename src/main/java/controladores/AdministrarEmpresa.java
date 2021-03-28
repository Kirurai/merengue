package controladores;

import entidades.Empresa;

import javax.persistence.EntityManager;
import java.util.List;

public class AdministrarEmpresa {

    private EntityManager entityManager;

    public AdministrarEmpresa(EntityManager em) {
        try {
            this.entityManager = em;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Alta(Empresa empresa) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(empresa);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public Empresa Buscar(int id) {
        return entityManager.find(Empresa.class, id);
    }

    public void Modificar(int id, Empresa empresaModificada) {
        entityManager.getTransaction().begin();
        try {
            Empresa empresa = entityManager.find(Empresa.class, id);
            empresaModificada.setId(empresa.getId());
            entityManager.merge(empresaModificada);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void Baja(int id) {
        entityManager.getTransaction().begin();
        try {
            Empresa empresa = entityManager.find(Empresa.class, id);
            entityManager.remove(empresa);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public List<Empresa> Listar() {
        return entityManager.createQuery("SELECT a FROM Empresa a", Empresa.class).getResultList();
    }


}
