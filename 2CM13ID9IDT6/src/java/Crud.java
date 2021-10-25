
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
            PreparedStatement ps = con.prepareStatement("Select Id,Nombre from Usuario");
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
            
            PreparedStatement ps = con.prepareStatement("Select * from Usuario where Id=?");
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
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void updateUsuario(Usuario u){
        try {
            Connection con;
            Conexion c = new Conexion();
            con = c.getConexion();
            
            PreparedStatement ps1 = con.prepareStatement("Select id from Usuario where password=?");
            ps1.setString(1, u.getPassword());
            ResultSet rs = ps1.executeQuery();
            
            if(rs.next()){
            
            rs.close();
            ps1.close();
                System.out.println(u.getNombre());
            PreparedStatement ps2 = con.prepareStatement("Update Usuario set Nombre=?, ApellidoPat=?, ApellidoMat=? where id=?");
            ps2.setString(1, u.getNombre());
            ps2.setString(2, u.getApellidoPat());
            ps2.setString(3, u.getApellidoMat());
            ps2.setInt(4, u.getId());
            
            ps2.executeUpdate();
            
            ps2.close();
            
            }else{
                System.out.println("Error.");
                rs.close();
                ps1.close();
            }
            
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void deleteUsuario(int id){
        try {
            Connection con;
            Conexion c = new Conexion();
            con = c.getConexion();
            
            PreparedStatement ps = con.prepareStatement("Delete from Usuario where Id=?");
            ps.setInt(1, id);
            
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
