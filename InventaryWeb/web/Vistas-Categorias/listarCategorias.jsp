<%@page import="Model.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="lista" scope="session" class="java.util.List" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Inventario</title>
        <%@include file = "../WEB-INF/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
        <%@include file = "../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        
        <!--<div style="width: 600px;">-->
        <div class="col-auto bg-gray p-5 text-center">
            <a href="<%= request.getContextPath() %>/categorias?opcion=crear" class ="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button">
                Nueva categoria
            </a>
            <h3>Listado de Categorias</h3>
            <table class="table table-striped">
                <tr>
                    <th>
                        ID
                    </th>
                    <th>
                        NOMBRE
                    </th>
                    <th>
                        ESTADO
                    </th>
                    <th>
                        ACCIONES
                    </th>
                </tr>
                <%
                 for(int i = 0; i < lista.size(); i++){
                    Categoria categoria = new Categoria();
                    categoria = (Categoria)lista.get(i);
                 %>
                 <tr>
                     <td><%= categoria.getId_categoria() %></td>
                     <td><%= categoria.getNom_categoria() %></td>
                     <td><%= categoria.getEstado_categoria() %></td>
                     <td>
                         <a href="categorias?opcion=editar&&id=<%= categoria.getId_categoria() %>&&nombre=<%= categoria.getNom_categoria() %>&&estado=<%= categoria.getEstado_categoria() %>" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button">Editar</a>
                         <a href="categorias?opcion=eliminar&&id=<%= categoria.getId_categoria() %>&&nombre=<%= categoria.getNom_categoria() %>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button">Eliminar</a>
                     </td>
                 </tr>
                 <%
                 }
                 %>
            </table>
        </div>
        
        <%@include file = "../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>
