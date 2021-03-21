package controladores;

import entidades.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class AdministrarEmpresa {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public AdministrarEmpresa(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = this.entityManager.getTransaction();
    }

    public void Alta(Empresa empresa) {
        beginTransaction();
        entityManager.persist(empresa);
        commitTransaction();
    }

    public Empresa Buscar(int id) {
        return entityManager.find(Empresa.class, id);

    }

    public void Modificar(int id, @org.jetbrains.annotations.NotNull Empresa empresaModificada) {
        beginTransaction();
        Empresa empresa = entityManager.find(Empresa.class, id);
        empresaModificada.setId(empresa.getId());
        entityManager.merge(empresaModificada);
        commitTransaction();
    }

    public void Baja(int id) {
        beginTransaction();
        Empresa empresa = entityManager.find(Empresa.class, id);
        entityManager.remove(empresa);
        commitTransaction();
    }

    public List<Empresa> Listar() {
        return entityManager.createQuery("SELECT a FROM Empresa a", Empresa.class).getResultList();
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
            //entityManager.close();
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


}
