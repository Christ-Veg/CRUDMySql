
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Crud {
    public ArrayList<Usuario> getUsuarios(){
        Connection con;
        Conexion c = new Conexion();
        con = c.getConexion();
        ArrayList<Usuario> usuarios = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("Select Id,Nombre from Usuarios");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario(rs.getInt(1), rs.getString(2));
                usuarios.add(u);
            }
            rs.close();
            ps.close();
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    public Usuario getUsuario(int id){
        Usuario u = null;
        try {
            Connection con;
            Conexion c = new Conexion();
            con = c.getConexion();
            
            PreparedStatement ps = con.prepareStatement("Select * from Usuario where IdUsuario=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            u = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));   
            
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    public void createUsuario(Usuario u){
        
        try {
            Connection con;
            Conexion c = new Conexion();
            con = c.getConexion();
            
            PreparedStatement ps = con.prepareStatement("Insert into Usuario values (?,?,?,?,?)");
            ps.setInt(1, 0);
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellidoPat());
            ps.setString(4, u.getApellidoMat());
            ps.setString(5, u.getPassword());
            
            ps.executeUpdate();
            
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateUsuario(Usuario u){
        try {
            Connection con;
            Conexion c = new Conexion();
            con = c.getConexion();
            
            PreparedStatement ps = con.prepareStatement("Update Usuario set Nombre=? AND ApellidoPat=? AND ApellidoMat=?");
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellidoPat());
            ps.setString(3, u.getApellidoMat());
            
            ps.executeUpdate();
            
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteUsuario(int id){
        try {
            Connection con;
            Conexion c = new Conexion();
            con = c.getConexion();
            
            PreparedStatement ps = con.prepareStatement("Select * from Usuario where IdUsuario=?");
            ps.setInt(1, id);
            
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
