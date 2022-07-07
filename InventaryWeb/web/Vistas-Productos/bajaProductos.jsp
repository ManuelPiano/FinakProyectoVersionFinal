<%-- 
    Document   : bajaProductos
    Created on : 28 jun. 2022, 21:47:22
    Author     : jennisurio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ////request.getContextPath()
    String id_pro = request.getParameter("id");
    String nombre_pro = request.getParameter("nombre");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Baja Categorias</title>
        <%@include file = "../WEB-INF/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
         <%@include file = "../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        <div class="col-auto bg-gray p-5 text-center">
            <h1>Baja de Productos</h1>
            
            <h4>¿Realmente Desea Eliminar el producto?</h4>
            <h5>ID producto <%= id_pro %></h5>
            <h5>Nombre Producto <%= nombre_pro %></h5>
        </div>
        
        <!---->
        
        <div class="d-grid gap-5 d-md-flex justify-content-md-center">
            <a href="bajaProductos?respuesta=yes&&id=<%= id_pro %>" class="btn btn-primary btn-lg" role="button">Si / Aceptar</a>
            <!--<a href="< //request.getContextPath() >" class="btn btn-secondary btn-lg" role="button">No / Cancelar</a>-->
            <a href="productos?opcion=listar" class="btn btn-secondary btn-lg" role="button">No / Cancelar</a>
            
        </div>
        
        <div class="row justify-content-center">
        <div class="col-4 bg-white">
            &nbsp;
        </div>
        <div class="col-4 bg-white">
            &nbsp;
        </div>
      </div>
        
        
         <%@include file = "../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>
