
package tpprogramacion2;
import java.time.LocalDate;
import java.util.ArrayList;


public class Socio extends Usuario {
    private  LocalDate fechaIngreso;
    private ArrayList<Vehiculo> vehiculos;
    //private Garaje


    public Socio(LocalDate fechaIngreso, String nombre, String direccion, int dni, int telefono, String usuario, String password) {
        super(nombre, direccion, dni, telefono, usuario, password);
        this.fechaIngreso = fechaIngreso;
        this.vehiculos = new ArrayList<Vehiculo>();
    }
    
     public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
     }
     
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    
    public String socioToString(){
        String datos = "fecha de ingreso: \n"+getFechaIngreso().toString()+"Vehiculos: \n";
        String datosVehiculos="";
        if(vehiculos.size()>0){
            for(Vehiculo v: vehiculos){
                datosVehiculos+= v.ToString();
            }    
        }else{
            datosVehiculos="No posee";
        }
        return usuarioToString()+datos+datosVehiculos;
    }

  
    
    
    
    

   

    @Override
    public String getTipoUsuario() {
        return "SOCIO";
    }

 

    
    
}
