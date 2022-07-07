package Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;



public class Salir extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Salir</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Salir at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //HttpSession session= request.getSession(false);
            HttpSession session = request.getSession();
            try{
            //Se puede resetear o limpiar las variables de sesión de esta manera.
            session.invalidate();
            //Se puede resetear o limpiar las variables de sesión de esta otra manera. Usar una a la vez.
            /*session.removeAttribute("sessionNombres");
            session.removeAttribute("sessionTipo");
            session.removeAttribute("sessionUsuario");
            session.removeAttribute("sessionEmail");*/
            
            /*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("./");
            dispatcher.forward(request, response);*/
            response.sendRedirect("./");
            //response.sendRedirect("usuario/?eliminado=exito");
            
            }catch(Exception e){
                 e.printStackTrace();
            }  
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
