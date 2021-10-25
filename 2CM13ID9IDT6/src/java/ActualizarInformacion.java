
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActualizarInformacion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String Nombre = request.getParameter("Nombre");
        String ApellidoPat = request.getParameter("ApellidoPat");
        String ApellidoMat = request.getParameter("ApellidoMat");
        String Password = request.getParameter("Password");
        int id = Integer.parseInt(request.getParameter("id"));
        
        Usuario usuario = new Usuario(id,Nombre,ApellidoPat,ApellidoMat,Password);
        Crud crud = new Crud();
        
        
        crud.updateUsuario(usuario);
        response.sendRedirect("menu");
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
