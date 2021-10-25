
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActualizarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        int id = Integer.parseInt(request.getParameter("id"));
        Crud crud = new Crud();
        Usuario usuario = crud.getUsuario(id);
        
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Actualizar Usuario</title>");  
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='ActualizarInformacion' method='post'");
            out.println("<div class='container'>");
            out.println("<div class='card'>");
            out.println("<div class='card-body'>");
            out.println("<h1 class='card-title'>Actualizar Usuario</h1>");
            out.println("<div class='form-group'>");
            out.println("<label for='Nombre'>Nombre</label>");
            out.println("<input type='text' class='form-control' name='Nombre' value='"+usuario.getNombre()+"'>");
            out.println("<label for='ApellidoPat'>Apellido Paterno</label>");
            out.println("<input type='text' class='form-control' name='ApellidoPat' value='"+usuario.getApellidoPat()+"'>");
            out.println("<label for='ApellidoMat'>Apellido Materno</label>");
            out.println("<input type='text' class='form-control' name='ApellidoMat' value='"+usuario.getApellidoMat()+"'>");
            
            out.println("</div>");
            out.println("<label for='Password'>Contrase&ntilde;a</label>");
            out.println("<input type='password' class='form-control' name='Password'>");
            out.println("<input type='hidden' name='id' value='"+id+"'>");
            out.println("<a href='index.html'><input type='submit' class='btn btn-primary' value='Actualizar'></a>");
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
