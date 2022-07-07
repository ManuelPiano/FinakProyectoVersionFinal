package Controller;
import DAO.ProductoDAO;
import DAO.ProductoDAOImplementar;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class BajaProductos extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BajaProductos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BajaProductos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        */
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String respuesta = request.getParameter("respuesta");
        String id = request.getParameter("id");
        
        ProductoDAO producto = new ProductoDAOImplementar();
        if(producto.borrarPro(Integer.parseInt(id))==true){
            System.out.println("Registro eliminado correctamente.");
            this.listaProductos(request, response);
        }else{
            System.out.println("Error. No se puede eliminar el registro.");
        }
    }
    private void listaProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductoDAO producto = new ProductoDAOImplementar();
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("lista", producto.Listar());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Productos/listarProductos.jsp");
        dispatcher.forward(request, response);
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    }


