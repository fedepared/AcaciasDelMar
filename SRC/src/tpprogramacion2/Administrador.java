
package tpprogramacion2;

import java.time.LocalDate;
import java.util.ArrayList;
import tpprogramacion2.Input;
import tpprogramacion2.Socio;
import tpprogramacion2.Vehiculo;

public class Administrador extends Usuario{

    public Administrador(String nombre, String direccion, int dni, int telefono, String usuario, String password) {
        super(nombre, direccion, dni, telefono, usuario, password);
    }
    
    public Administrador crearAdministrador(){
        Input.mostrarMensaje("Ingrese nombre del administrador");
        String nombre = Input.obtenerString();
        Input.mostrarMensaje("Ingrese la dirección del administrador");
        String direccion = Input.obtenerString();
        Input.mostrarMensaje("Ingrese el numero de dni del administrador");
        int dni = Input.obtenerEntero();
        Input.mostrarMensaje("Ingrese el numero de telefono del administrador");
        int telefono = Input.obtenerEntero();
        Input.mostrarMensaje("Ingrese el nombre de usuario a crear");
        String nombreDeUsuario = Input.obtenerString();
        Input.mostrarMensaje("Ingrese el password del usuario a crear");
        String password = Input.obtenerString();
        Input.mostrarMensaje("Desea agregar vehiculos al usuario? [S]Si,[N]No");
        
        return new Administrador(nombre,direccion,dni,telefono,nombreDeUsuario,password);
    }
    
    public Socio crearSocio(){
        Input.mostrarMensaje("Ingrese nombre del socio");
        String nombre = Input.obtenerString();
        Input.mostrarMensaje("Fecha de ingreso del socio:");
        LocalDate fechaIngreso= Input.obtenerFecha();
        Input.mostrarMensaje("Ingrese la dirección del socio");
        String direccion = Input.obtenerString();
        Input.mostrarMensaje("Ingrese el numero de dni del socio");
        int dni = Input.obtenerEntero();
        Input.mostrarMensaje("Ingrese el numero de telefono del socio");
        int telefono = Input.obtenerEntero();
        Input.mostrarMensaje("Ingrese el nombre de usuario a crear");
        String nombreDeUsuario = Input.obtenerString();
        Input.mostrarMensaje("Ingrese el password del usuario a crear");
        String password = Input.obtenerString();
        Input.mostrarMensaje("Desea agregar vehiculos al usuario? [S]Si,[N]No");
        String respuesta = Input.obtenerString();
        Socio nuevoSocio = new Socio(fechaIngreso,nombre,direccion,dni,telefono,nombreDeUsuario,password);
        
        if(respuesta.toUpperCase().charAt(0) == 'S'){
            ArrayList<Vehiculo> autosDelSocio = new ArrayList<Vehiculo>();
            do{
                Input.mostrarMensaje("Ingrese la matricula del vehiculo");
                String matricula = Input.obtenerString();
                Input.mostrarMensaje("Ingrese la marca/modelo del vehiculo");
                String modeloMarcaVehiculo = Input.obtenerStringNextLine();
                String tipo = new String();
                do{
                    Input.mostrarMensaje("Ingrese el tipo correcto de vehiculo");
                    Input.mostrarMensaje("Opciones: motorhome \n casa rodante \n casa rodante de arrastre \n caravana \n trailer ");
                    tipo = Input.obtenerStringNextLine().toLowerCase();
                    
                }while(!tipo.equals("motorhome") || !tipo.equals("casa rodante") || !tipo.equals("casa rodante de arrastre") || !tipo.equals("caravana")|| !tipo.equals("trailer"));
                
                Input.mostrarMensaje("Ingrese las dimensiones, con valor numerico:");
                Input.mostrarMensaje("Ingrese el ancho:");
                double ancho = Input.obtenerDouble();
                Input.mostrarMensaje("Ingrese el largo:");
                double profundidad = Input.obtenerDouble();
                Vehiculo autoNuevo = new Vehiculo(matricula,modeloMarcaVehiculo,tipo,ancho,profundidad);
                autosDelSocio.add(autoNuevo);
                Input.mostrarMensaje("Desea seguir agregando vehiculos al usuario? [S]Si,[N]No");
                respuesta = Input.obtenerString();
            }while(respuesta.toUpperCase().charAt(0) == 'S');
        }
        
        return nuevoSocio;
    }
    
    public Empleado crearEmpleado(){
        Input.mostrarMensaje("Ingrese codigo del empleado");
        int codigoEmpleado = Input.obtenerEntero();
        Input.mostrarMensaje("Ingrese especialidad del empleado:");
        String especialidad = Input.obtenerString();
        Input.mostrarMensaje("Ingrese nombre del empleado:");
        String nombre = Input.obtenerStringNextLine();
        Input.mostrarMensaje("Ingrese la dirección del empleado");
        String direccion = Input.obtenerStringNextLine();
        Input.mostrarMensaje("Ingrese el numero de dni del socio");
        int dni = Input.obtenerEntero();
        Input.mostrarMensaje("Ingrese el numero de telefono del socio");
        int telefono = Input.obtenerEntero();
        Input.mostrarMensaje("Ingrese el nombre de usuario a crear");
        String nombreDeUsuario = Input.obtenerString();
        Input.mostrarMensaje("Ingrese el password del usuario a crear");
        String password = Input.obtenerString();
        return new Empleado(codigoEmpleado,especialidad,nombre,direccion,dni,telefono,nombreDeUsuario,password);
    
    }
    
    
    public Garage crearGarage(){
        Input.mostrarMensaje("Ingrese el numero del garage");
        int numero = Input.obtenerEntero();
        Input.mostrarMensaje("Ingrese lectura del contador de luz (0 si recien comienza)");
        double lecturaContador = Input.obtenerDouble();
        Input.mostrarMensaje("Tiene servicio de mantenimiento contratado? [S]Si,[N]No");
        boolean servicioMantenimiento = Input.obtenerString().toUpperCase().charAt(0) == 'S'; 
        Input.mostrarMensaje("Ingrese las dimensiones, con valor numerico:");
        Input.mostrarMensaje("Ingrese el ancho:");
        double ancho = Input.obtenerDouble();
        Input.mostrarMensaje("Ingrese el largo:");
        double profundidad = Input.obtenerDouble();
        Garage garage = new Garage(numero,lecturaContador,servicioMantenimiento,ancho,profundidad);
        
        
        
        return garage;    
    };
    
    public Zona crearZona(){
        Input.mostrarMensaje("Ingrese la letra de la zona:");
        char nombreZona= Input.obtenerString().charAt(0);
        ArrayList<String> vehiculosAdmitidos = new ArrayList<String>();
        Input.mostrarMensaje("Ingrese los tipos de vehiculos admitidos de a uno por vez (finaliza escribiendo la palabra fin):");
        Input.mostrarMensaje("Opciones: motorhome \n casa rodante \n casa rodante de arrastre \n caravana \n trailer ");
        String tipo = new String();
        tipo = Input.obtenerStringNextLine().toLowerCase();
        while(!tipo.equals("fin")){
            //chequeo que haya escrito bien
            while(!tipo.equals("motorhome") || !tipo.equals("casa rodante") || !tipo.equals("casa rodante de arrastre") || !tipo.equals("caravana")|| !tipo.equals("trailer")){
               Input.mostrarMensaje("No ha ingresado el tipo correcto:"); 
               Input.mostrarMensaje("Opciones: motorhome \n casa rodante \n casa rodante de arrastre \n caravana \n trailer \n fin(para finalizar carga)");
               tipo = Input.obtenerStringNextLine().toLowerCase();
            };
            
            vehiculosAdmitidos.add(tipo);
            Input.mostrarMensaje("Ingrese los tipos de vehiculos admitidos de a uno por vez (finaliza escribiendo la palabra fin):");
            Input.mostrarMensaje("Opciones: motorhome \n casa rodante \n casa rodante de arrastre \n caravana \n trailer ");
            tipo = Input.obtenerStringNextLine().toLowerCase();
        };
        Zona zonaNueva = new Zona(nombreZona,vehiculosAdmitidos);
        
        return zonaNueva;    
    };
    
    public CompraGarage comprarGarage(Socio socio, Garage garage){
        Input.mostrarMensaje("Fecha de compra:");
        LocalDate fechaCompra = Input.obtenerFecha();
        CompraGarage compraDeGarage = new CompraGarage(fechaCompra,garage,socio);
        return compraDeGarage;
    }
    
    public AsignacionZonaEmpleadoVehiculo asignarVehiculoZonaEmpleado(Zona zona,Empleado empleado,Vehiculo vehiculo){
        return new AsignacionZonaEmpleadoVehiculo(zona,empleado,vehiculo);
    }
    
    public AsignacionVehiculoGarage asignarVehiculoGarage(Garage gar,Vehiculo vehic){
        Input.mostrarMensaje("Fecha de asignacion: ");
        LocalDate fechaAsignacion = Input.obtenerFecha();
        return new AsignacionVehiculoGarage(fechaAsignacion,gar,vehic);
    }
    
    public Socio getSocio(ArrayList<Usuario> usuarios){
        Input.mostrarMensaje("Ingrese el nombre del socio");
        String nombreSocio = Input.obtenerStringNextLine();
        for(Usuario u: usuarios){
            if(u.getNombre().toLowerCase() == nombreSocio && u.getTipoUsuario() == "SOCIO"){
                return (Socio)u;
            }
        }
        return null;
    }
    
    public void getSocios(ArrayList<Usuario> usuarios){
        for(Usuario u: usuarios){
            if(u.getTipoUsuario() == "SOCIO"){
                Socio socio = (Socio)u;
                Input.mostrarMensaje(socio.socioToString());
            }
        }
    }
    
    public void getEmpleados(ArrayList<Usuario> usuarios){
        for(Usuario u: usuarios){    
            if(u.getTipoUsuario() == "EMPLEADO"){
                Empleado empleado = (Empleado)u;
                Input.mostrarMensaje(empleado.empleadoToString());
            }
        }
    }
    
    public void getAdmins(ArrayList<Usuario> usuarios){
        for(Usuario u: usuarios){    
            if(u.getTipoUsuario() == "ADMINISTRADOR"){
                Administrador admin = (Administrador)u;
                Input.mostrarMensaje(admin.adminToString());
            }
        }
    }
    
    public String adminToString(){
           return usuarioToString();
    }
    
    
    
        
        
        
    
   

    @Override
    public String getTipoUsuario() {
        return "ADMINISTRADOR";
    }

    
    
    
    
}
