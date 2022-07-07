package Controller;
import DAO.ProductoDAO;
import DAO.ProductoDAOImplementar;
import Model.Producto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 * @author manuelpiano31
 */
public class ActualizoProductos extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       /*  try ( PrintWriter out = response.getWriter()) {
            TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActualizoProductos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizoProductos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String id_pro =request.getParameter("id");
        String nombre_pro = request.getParameter("nombre");
        String estado_pro = request.getParameter("estado");
        String stock_pro = request.getParameter("stock");
        String precio_pro = request.getParameter("precio");
        String unidad_medida = request.getParameter("UnidadMedida");
        String categoriaa = request.getParameter("NomCatogoria");
        
        ProductoDAO producto = new ProductoDAOImplementar();
        Producto pro = new Producto();
        pro.setId_producto(Integer.parseInt(id_pro));
        pro.setNom_producto(nombre_pro);
        pro.setEstado(Integer.parseInt(estado_pro));
        pro.setStock(Double.parseDouble(stock_pro));
        pro.setPrecio(Double.parseDouble(precio_pro));
        pro.setUnidadMedida(unidad_medida);
        pro.setCatogoria_nom(categoriaa);
        if(producto.guardarPro(pro)==true){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Productos/editarProductos.jsp?aviso=ok");
            dispatcher.forward(request, response);
        }else{
            System.out.println("Error. El producto no se pudo actualizar");
        }
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
