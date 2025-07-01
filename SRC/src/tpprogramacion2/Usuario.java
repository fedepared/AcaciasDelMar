package tpprogramacion2;

public  abstract class  Usuario {
    
    private String nombre;
    private String direccion;
    private int dni;
    private int telefono;
    private String usuario ;
    private String password ;

    public Usuario(String nombre, String direccion, int dni, int telefono, String usuario, String password) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
        this.usuario = usuario;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

  
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String usuarioToString(){
      return "nombre: "+ getNombre()+"\n" + "direccion: "+ getDireccion()+"\n"+"telefono: "+getTelefono()+"\n";
     
    }
    
    
   public abstract String getTipoUsuario();
}

