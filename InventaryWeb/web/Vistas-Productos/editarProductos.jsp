<%@page import="Model.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.CategoriaDAOImplementar"%>
<%@page import="DAO.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   
        String id_pro =request.getParameter("id");
        String nombre_pro = request.getParameter("nombre");
        String estado_pro = request.getParameter("estado");
        String stock = request.getParameter("stock");
        String precio_pro = request.getParameter("precio");
        String unidad_medida = request.getParameter("UnidadMedida");
        String categoriaa = request.getParameter("NomCatogoria");
    
    /*out.print("El ID de la categoria es: " + id_cat);
    out.print("El nombre de la categoria es: " + nombre_cat);
    out.print("El estado de la categoria es: " + estado_cat);*/
 %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file = "../WEB-INF/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body class="justify-content-center">
         <%@include file = "../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
         <div class="col-auto bg-gray p-5 text-center">
        <h1 class='text-center'>Información de Categoria</h1>
        <form action="actualizoProductos" method="post">
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">ID Producto:</label>
            <div class="col-sm-10">
              <input type="text" value='<%= id_pro %>' name="id1" id="id1" readonly class="form-control-plaintext" id="staticEmail" placeholder="ID Producto">
              <input type="hidden" value='<%= id_pro %>' name="id" id="id" readonly class="form-control-plaintext" id="staticEmail" >
            </div>
        </div>
            
        <div class="mb-3 row">
          <label for="inputPassword" class="col-sm-2 col-form-label">Nombre Producto</label>
          <div class="col-sm-10">
              <input type="text" value='<%= nombre_pro %>' name="nombre" id="nombre" class="form-control" placeholder="Nombre Producto" required="true">
          </div>
        </div>
          
          <div class="mb-3 row">
          <label for="inputPassword" class="col-sm-2 col-form-label">Estado Producto</label>
          <div class="col-sm-10">
              <input type="text" value='<%= estado_pro %>' name="estado" id="estado" class="form-control" placeholder="Estado Producto" required="true">
          </div>
        </div>
           <div class="mb-3 row">
          <label for="inputPassword" class="col-sm-2 col-form-label">Stock Producto</label>
          <div class="col-sm-10">
              <input type="text" value='<%= stock %>' name="stock" id="stock" class="form-control" placeholder="stock Producto" required="true">
          </div>
        </div>
           <div class="mb-3 row">
          <label for="inputPassword" class="col-sm-2 col-form-label">Precio Producto</label>
          <div class="col-sm-10">
              <input type="text" value='<%= precio_pro %>' name="precio" id="precio" class="form-control" placeholder="precio Producto" required="true">
          </div>
        </div>
           <div class="mb-3 row">
          <label for="inputPassword" class="col-sm-2 col-form-label">Unidad de medida Producto</label>
          <div class="col-sm-10">
              <input type="text" value='<%= unidad_medida %>' name="UnidadMedida" id="UnidadMedida" class="form-control" placeholder="unidad medida Producto" required="true">
          </div>
        </div>
          <div class="mb-3 row">
          <label for="inputPassword" class="col-sm-2 col-form-label">Categoria Producto</label>
          <div class="col-sm-10">
              <label for="NomCatogoria" class="form-label">Select list (select one):</label>
    <select class="form-select" id="NomCatogoria" name="NomCatogoria">
        
        
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
          </div>
        </div>
          
          <div class="mb-3 row">
          <button type="submit" name="send" class="btn btn-success">Actualizar Producto</button>
          </div>
        </form>
          
          <%
            String dato = request.getParameter("aviso");
            if(dato!=null){
                //out.print("Registro Actualizado Correctamente");
                //System.out.println("End");
           %>
                   <div class="alert alert-success" role="alert">
                   Modificado!!
                 </div>
           <%   
               }
           %>

        </div>
         <%@include file = "../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
    
    
</html>
