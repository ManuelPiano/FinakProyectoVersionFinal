<%-- 
    Document   : crearProductos
    Created on : 28 jun. 2022, 21:47:48
    Author     : manuelpiano31
--%>
<%@page import="Model.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.CategoriaDAOImplementar"%>
<%@page import="DAO.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="producto" scope="session" class="Model.Producto" />

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
            <h3 class='text-center'>Registro Productos</h3>
            <form class="form-horizontal" id="frmProducto" name="frmProducto" action="<%= request.getContextPath() %>/productos" method="post">
                <div class="row">&nbsp;</div>
                <input type="hidden" name="id_producto" id="id_producto" value="<%= producto.getId_producto() %>" >
                <div class="form-group">
                   <label for="txtNomProducto" class="col-sm-2 control-label">Nombre Producto</label>
                   <div class="col-sm-12">
                       <input type="text" class="form-control" name="txtNomProducto" id="txtNomProducto" value="<%= producto.getNom_producto() %>" placeholder="Nombre Producto" required="true"> 
                   </div>
                </div>
                   
                <div class="form-group">
                   <label for="txtEstadoProducto" class="col-sm-2 control-label">Estado</label>
                   <div class="col-sm-12">
                       <input type="text" class="form-control" name="txtEstadoProducto" id="txtEstadoProducto" value="<%= producto.getEstado() %>" placeholder="Estado producto" required="true"> 
                   </div>
                </div>
                   <div class="form-group">
                   <label for="txtprecio" class="col-sm-2 control-label">Precio</label>
                   <div class="col-sm-12">
                       <input type="text" class="form-control" name="txtprecio" id="txtprecio" value="<%= producto.getPrecio() %>" placeholder="Precio producto" required="true"> 
                   </div>
                </div>
                   <div class="form-group">
                   <label for="txtstock" class="col-sm-2 control-label">Stock</label>
                   <div class="col-sm-12">
                       <input type="text" class="form-control" name="txtstock" id="txtstock" value="<%= producto.getStock() %>" placeholder="Stock producto" required="true"> 
                   </div>
                </div>
                   <div class="form-group">
                   <label for="txtUnidad" class="col-sm-2 control-label">Unidad de Medida</label>
                   <div class="col-sm-12">
                       <input type="text" class="form-control" name="txtUnidad" id="txtUnidad" value="<%= producto.getUnidadMedida() %>" placeholder="Unidad Medida producto" required="true"> 
                   </div>
                </div>
                   <label for="txtcatogoria" class="form-label">Select list (select one):</label>
    <select class="form-select" id="txtcatogoria" name="txtcatogoria">
        
        
        <%
                                   CategoriaDAO categoria = new CategoriaDAOImplementar();
                                   List<Categoria> cat = new ArrayList<Categoria>();
                                   
                                   cat = categoria.Listar();
                                   for(int i = 0; i < cat.size() ; i++)
                                   {
                                   Categoria categ = cat.get(i);
                                   %>
      <option value="<%= categ.getId_categoria() %>"><%= categ.getNom_categoria()%></option>
      <%      
                               }
                               %>
    </select>
                   <div class="row">&nbsp;</div>
                    <div class="row">&nbsp;</div>
                   <div class="form-group">
                       <div class="col-sm-offset-2 col-sm-12">
                           <input type="submit" class="btn btn-success btn-sm" value="Guardar" name="btnGuardar"/> 
                           <input type="button" class="btn btn-danger btn-sm" name="btnRegresar" value="Regresar" onclick="regresar('<%= request.getContextPath() %>/productos?opcion=listar')"/> 
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
