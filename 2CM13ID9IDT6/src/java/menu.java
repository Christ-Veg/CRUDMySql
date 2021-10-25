
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class menu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Homework 6</title>\n" +
"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<div class=\"container\">\n" +
"            <h1>CREAR, ALTAS, BAJAS Y CAMBIOS</h1>\n" +
"            <p><a href=\"CrearUsuario.html\">Crear nuevo usuario</a></p>\n" +
"            <div class=\"card\">\n" +
"                <table class=\"table table-striped\">\n" +
"                <thead>\n" +
"                    <tr>\n" +
"                        <th scope=\"col\">Nombre del diagrama de perfil</th>\n" +
"                        <th scope=\"col\">Acciones</th>\n" +
"                    <tr>\n" +
"                </thead>\n");
            
            Crud crud = new Crud();
            ArrayList<Usuario> usuarios = crud.getUsuarios();
            System.out.println(usuarios.get(0).getId());
            for (Usuario usuario : usuarios) {
                out.println("<tr>"
                        + "<td>"+usuario.getNombre()+"</td>"
                        + "<td>"
                                + "<a href='VerUsuario?id="+usuario.getId()+"'>Leer registro de usuario</a>|"
                                + "<a href='ActualizarUsuario?id="+usuario.getId()+"'>Modificar usuario</a>|"
                                + "<a href='EliminarUsuario?id="+usuario.getId()+"'>Eliminar usuario</a>"
                        + "</td>");
            }
            
            out.println("</table></div></div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
