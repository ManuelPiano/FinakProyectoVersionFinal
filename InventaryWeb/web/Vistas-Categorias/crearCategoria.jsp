<%-- 
    Document   : crearCategoria
    Created on : 21-jun-2022, 11:43:20
    Author     : ITCA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="categoria" scope="session" class="Model.Categoria" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de inventario</title>
         <%@include file = "../WEB-INF/Vistas-Parciales/css-js.jspf" %>
         <script type="text/javascript">
             function regresar(url){
                 location.href = url;
             }
         </script>
    </head>
    <body class="justify-content-center">
        <%@include file = "../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
         <div class="col-auto bg-gray p-5 text-center">
            <h3 class='text-center'>Registro Categorias</h3>
            <form class="form-horizontal" id="frmCategoria" name="frmCategoria" action="<%= request.getContextPath() %>/categorias" method="post">
                <div class="row">&nbsp;</div>
                <input type="hidden" name="id_categoria" id="id_categoria" value="<%= categoria.getId_categoria() %>" >
                <div class="form-group">
                   <label for="txtNomCategoria" class="col-sm-2 control-label">Nombre Categoria</label>
                   <div class="col-sm-12">
                       <input type="text" class="form-control" name="txtNomCategoria" id="txtNomCategoria" value="<%= categoria.getNom_categoria() %>" placeholder="Nombre categoria" required="true"> 
                   </div>
                </div>
                   
                <div class="form-group">
                   <label for="txtEstadoCategoria" class="col-sm-2 control-label">Estado</label>
                   <div class="col-sm-12">
                       <input type="text" class="form-control" name="txtEstadoCategoria" id="txtEstadoCategoria" value="<%= categoria.getEstado_categoria() %>" placeholder="Estado categoria" required="true"> 
                   </div>
                </div>
                   <div class="row">&nbsp;</div>
                    <div class="row">&nbsp;</div>
                   <div class="form-group">
                       <div class="col-sm-offset-2 col-sm-12">
                           <input type="submit" class="btn btn-success btn-sm" value="Guardar" name="btnGuardar"/> 
                           <input type="button" class="btn btn-danger btn-sm" name="btnRegresar" value="Regresar" onclick="regresar('<%= request.getContextPath() %>/categorias?opcion=listar')"/> 
                       </div>
                   </div>
                   
                <div class="row">&nbsp;</div>
                <div class="row">&nbsp;</div>
                <div class="row">&nbsp;</div>
            </form>
         </div>
        <%@include file = "../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>
