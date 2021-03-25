<%@ page import="entidades.Empresa" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controladores.AdministrarEmpresa" %>
<%@ page import="java.util.List" %>

<%! List<Empresa> empresas = AdministrarEmpresa.Listar(); %>
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
                //Se pasaría como petición get?
                out.println(String.format("<a href='%s'>Home %s</a>", emp.getId(), emp.getDenominacion()));
                out.println("</td>");
                out.println("</tr>");
            }
        %>
        <td>
            XXXXXXXX
        </td>
        <td>
            <a href="home.html?id=1">URL PAGINA HOME</a>
        </td>
    </tr>
</table>