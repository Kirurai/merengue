<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%@ page import="entidades.Empresa" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controladores.AdministrarEmpresa" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="javax.persistence.EntityManagerFactory" %>
<%@ page import="javax.persistence.Persistence" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="controladores.AdministrarNoticia" %>

<%! EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppPU");
    EntityManager em = emf.createEntityManager();
    AdministrarEmpresa administrarEmpresa = new AdministrarEmpresa(em);
    AdministrarNoticia administrarNoticia = new AdministrarNoticia(em);
    List<Empresa> empresas = administrarEmpresa.Listar(); %>
<table width="50%" align="center">
    <tr>
        <td width="50%">
            <b>EMPRESA</b>
        </td>
        <td>
            <b>VER PAGINA</b>
        </td>
    </tr>
    <tr>
        <%
            for(Empresa emp : empresas){
                out.println("<tr>");
                out.println("<td>");
                out.println(emp.getDenominacion());
                out.println("</td>");
                out.println("<td>");
                //Se pasaría como petición get? Está bien asi?
                out.println(String.format("<a href='home.html?id=%s'>Home %s</a>", emp.getId(), emp.getDenominacion()));
                out.println("</td>");
                out.println("</tr>");
            }
        %>
    </tr>
</table>
</body>
</html>