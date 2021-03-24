package main;

import controladores.AdministrarEmpresa;
import entidades.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args){

            //Prueba AdministradorEmpresa
            AdministrarEmpresa administrarEmpresa = new AdministrarEmpresa();

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

    }


}
