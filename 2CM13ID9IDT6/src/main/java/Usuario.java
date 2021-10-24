
public class Usuario {
    private int Id;
    private String Nombre;
    private String ApellidoPat;
    private String ApellidoMat;
    private String Password;

    public Usuario(int Id, String Nombre) {
        this.Id = Id;
        this.Nombre = Nombre;
    }

    
    public Usuario(int Id, String Nombre, String ApellidoPat, String ApellidoMat, String Password) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.ApellidoPat = ApellidoPat;
        this.ApellidoMat = ApellidoMat;
        this.Password = Password;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPat() {
        return ApellidoPat;
    }

    public void setApellidoPat(String ApellidoPat) {
        this.ApellidoPat = ApellidoPat;
    }

    public String getApellidoMat() {
        return ApellidoMat;
    }

    public void setApellidoMat(String ApellidoMat) {
        this.ApellidoMat = ApellidoMat;
    }
    
    
}
