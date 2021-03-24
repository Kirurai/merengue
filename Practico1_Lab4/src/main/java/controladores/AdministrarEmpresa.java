package controladores;

import entidades.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class AdministrarEmpresa {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    private EntityManagerFactory entityManagerFactory;


    public AdministrarEmpresa() {
//        try {
//            crearEmEmf();
//        }catch (Exception e){
//
//        }
    }

    private void crearEmEmf(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("AppPU");
        this.entityManager = this.entityManagerFactory.createEntityManager();
        this.entityTransaction = this.entityManager.getTransaction();
    }

    public void Alta(Empresa empresa) {
        crearEmEmf();
        entityManager.persist(empresa);
        commitTransaction();
        cerrarEmEmf();
    }

    public Empresa Buscar(int id) {
        crearEmEmf();
        Empresa EmpresaResultado = entityManager.find(Empresa.class, id);
        cerrarEmEmf();
        return EmpresaResultado;
    }

    public void Modificar(int id, @org.jetbrains.annotations.NotNull Empresa empresaModificada) {
        crearEmEmf();
        beginTransaction();
        Empresa empresa = entityManager.find(Empresa.class, id);
        empresaModificada.setId(empresa.getId());
        entityManager.merge(empresaModificada);
        commitTransaction();
        cerrarEmEmf();
    }

    public void Baja(int id) {
        crearEmEmf();
        beginTransaction();
        Empresa empresa = entityManager.find(Empresa.class, id);
        entityManager.remove(empresa);
        commitTransaction();
        cerrarEmEmf();
    }

    public List<Empresa> Listar() {
        crearEmEmf();
        List<Empresa> ResultadoLista = entityManager.createQuery("SELECT a FROM Empresa a", Empresa.class).getResultList();
        cerrarEmEmf();
        return ResultadoLista;
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
            //limpiar conexion

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

    private void cerrarEmEmf(){
        //cerrar conexion de em y emf
        //this.entityManager.flush();
        this.entityManager.close();
        this.entityManagerFactory.close();
    }


}
