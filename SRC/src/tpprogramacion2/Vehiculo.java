package tpprogramacion2;



public class Vehiculo {
   private String Matricula;
   private String Nombre;
   private String tipo;
   private double profundidad;
   private double ancho;

    public Vehiculo(String Matricula, String Nombre, String tipo, double profundidad, double ancho) {
        this.Matricula = Matricula;
        this.Nombre = Nombre;
        this.tipo = tipo;
        this.profundidad = profundidad;
        this.ancho = ancho;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    
    public String ToString()
    {
        return "matricula: "+getMatricula()+"\n"+"tipo: "+getTipo()+"\n";
    }
   
   
}
