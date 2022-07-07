package Controller;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class Categorias extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Categorias</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Categorias at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         
         //this.listaCategorias(request, response);
         
         String estado = request.getParameter("opcion");
         String id_cat = request.getParameter("id");
         String nombre_cat = request.getParameter("nombre");
         String estado_cat = request.getParameter("estado");
         /*
         System.out.println("La opcion es: " + estado);
         System.out.println("El ID es: " + id_cat);
         System.out.println("El nombre es: " + nombre_cat);
         System.out.println("El estado es. " + estado_cat);
         */
    
         if(estado.equals("listar")){
             this.listaCategorias(request, response);
         }else if(estado.equals("editar")){
             System.out.println("Editando categorias....");
             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Categorias/editarCategorias.jsp?id="+id_cat+"&&nombre="+nombre_cat+"&&estado="+estado_cat);
             dispatcher.forward(request, response);
         }else if(estado.equals("eliminar")){
             System.out.println("Baja de categorias...");
             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Categorias/bajaCategorias.jsp?id="+id_cat+"&&nombre="+nombre_cat);
             dispatcher.forward(request, response);
         }else if(estado.equals("crear")){
             System.out.println("Crear categorias...");
             String pagina = "/Vistas-Categorias/crearCategoria.jsp";
             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
             dispatcher.forward(request, response);
         }else{
             
         }
         
         
         
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        /*System.out.println("Id_categoria: " + request.getParameter("id_categoria"));
         System.out.println("Nombre categoria: " + request.getParameter("txtNomCategoria"));
          System.out.println("Estado categoria: " + request.getParameter("txtEstadoCategoria"));*/
        
        Categoria categoria = new Categoria();
        categoria.setId_categoria(Integer.parseInt(request.getParameter("id_categoria")));
        categoria.setNom_categoria(request.getParameter("txtNomCategoria"));
        categoria.setEstado_categoria(Integer.parseInt(request.getParameter("txtEstadoCategoria")));
        CategoriaDAO guardaCategoria = new CategoriaDAOImplementar();
        guardaCategoria.guardarCat(categoria);
        this.listaCategorias(request, response);
        
    }
    
    protected void listaCategorias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         CategoriaDAO categoria = new CategoriaDAOImplementar();
         HttpSession sesion = request.getSession(true);
         sesion.setAttribute("lista", categoria.Listar());
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Categorias/listarCategorias.jsp");
         dispatcher.forward(request, response);
         
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
