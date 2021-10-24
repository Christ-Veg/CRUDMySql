
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VerUsuario</title>");  
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<div class='card'>");
            out.println("<div class='card-body'>");
            out.println("<h1 class='card-title'>Agregar Usuario</h1>");
            out.println("<form action='VerUsuario' method='post'>");
            out.println("<div class='form-group'>");
            out.println("<label for='Nombre'>Nombre</label>");
            out.println("<input type='text' class='form-control' name='Nombre'>");
            out.println("<label for='ApellidoPat'>Apellido Paterno</label>");
            out.println("<input type='text' class='form-control' name='ApellidoPat'>");
            out.println("<label for='ApellidoMat'>Apellido Materno</label>");
            out.println("<input type='text' class='form-control' name='ApellidoMat'>");
            out.println("<label for='Password'>Contrase&ntilde;a</label>");
            out.println("<input type='Password' class='form-control' name='Password'>");
            out.println("</div>");
            out.println("<input type='submit' class='btn btn-primary' value='Enviar'>");
            out.println("<a href='index.html'><input type='reset' class='btn btn-danger' value='Cancelar'></a>");
            out.println("</form>");
            out.println("</div></div></div>");
            out.println("</body>");
            out.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
