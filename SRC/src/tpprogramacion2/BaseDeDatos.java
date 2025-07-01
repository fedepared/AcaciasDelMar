package tpprogramacion2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDeDatos {

    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Zona> zonas;
    private static ArrayList<Garage> garages;
    private static ArrayList<AsignacionVehiculoGarage> asignacionesVehicGarage;
    private static ArrayList<AsignacionZonaEmpleadoVehiculo> asignacionesEmpleadosZonasVehiculos;
    private static ArrayList<CompraGarage> comprasGarage;
    
    
    
    public BaseDeDatos() {
        usuarios = new ArrayList<Usuario>();
        zonas = new ArrayList<Zona>();
        garages = new ArrayList<Garage>();
        asignacionesVehicGarage =new ArrayList<AsignacionVehiculoGarage>();
        asignacionesEmpleadosZonasVehiculos = new ArrayList<AsignacionZonaEmpleadoVehiculo>();
        comprasGarage=new ArrayList<CompraGarage>();    
        
        inicializarUsuariosDemo();
    }

    public  ArrayList<AsignacionZonaEmpleadoVehiculo> getAsignacionesEmpleadosZonasVehiculos() {
        return asignacionesEmpleadosZonasVehiculos;
    }

    public  ArrayList<AsignacionVehiculoGarage> getAsignacionesVehicGarage() {
        return asignacionesVehicGarage;
    }



    public  ArrayList<CompraGarage> getComprasGarage() {
        return comprasGarage;
    }

    private void inicializarUsuariosDemo() { 
        // Administrador
        usuarios.add(new Administrador(
                "Mica Flores", "Calle Admin 123", 12345678, 912345678,
                "admin", "a123"
        ));
        // Empleado
        usuarios.add(new Empleado(
                1001, "Recepcionista", "Maria Garcia", "Calle Empleado 456", 1235145, 92222111,
                "emple1", "e123"
        ));

        // Socio
        Socio socio1 = (new Socio(LocalDate.now().minusMonths(6),
                "Carlos Ruiz", "Av. Socio 789", 1234235, 933333333,
                "socio1", "s123"
        ));
        socio1.agregarVehiculo(new Vehiculo("ABC123", "Toyota", "Corolla", 12, 12));
        usuarios.add(socio1);
        
    }
    
    public Usuario Autentificar(String use, String pws) {

        
        for (Usuario u : usuarios) {
            if (use.equals(u.getUsuario())&& pws.equals(u.getPassword()))
                return u;
        }
       
        
       return null;
    }
    
    public Usuario getUsuarioPorNombre(String nombreUsuario){
        for (Usuario u : usuarios) {
            if (nombreUsuario.equals(u.getNombre()))
                return u;
        }
        return null;
    }
    
    public Garage getGaragePorNumero(int numero){
        for(Garage g: garages){
            if(g.getNumero()==numero){
                return g;
            }
        }
        return null;
    }
    
    public Vehiculo getVehiculoPorMatricula(String matricula){
        for(Usuario u:usuarios){
            if(u.getTipoUsuario() == "SOCIO"){
                Socio socio = (Socio)u;
                ArrayList<Vehiculo> vehics=socio.getVehiculos();
                for(Vehiculo v:vehics)
                {
                    if(v.getMatricula().toLowerCase()== matricula.toLowerCase())
                        return v;
                }
            }
        }
        return null;
    }
    
    public Empleado getEmpleadoPorCodigoEmpleado(int codigo){
        for(Usuario u:usuarios){
            if(u.getTipoUsuario() == "EMPLEADO"){
                Empleado empleado = (Empleado)u;
                if(empleado.getCodigo()==codigo){
                    return empleado;
                }
            }
        }
        return null;
    }
    
    public Zona getZonaPorLetra(char letra){
        for(Zona z:zonas){
            if(letra == z.getLetra())
            {
                return z;
            }
        }
        return null;
    }
    
    //adds a las listas
    public void agregarZona(Zona zona){
        zonas.add(zona);
    }
    
    public void agregarGarage(Garage garage){
        garages.add(garage);
    }
    
    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    
    public void agregarAsignacionVehiculoGarage(AsignacionVehiculoGarage asignacion){
        Garage garage = asignacion.getGarage();
        char letraZonaDondeEstaElGarage = garage.getZonaAsignada().getLetra();
        for(Zona z:zonas){
            if (z.getLetra() == letraZonaDondeEstaElGarage)
                z.sumarUnVehiculoAsignado();
        }
        
        asignacionesVehicGarage.add(asignacion);
    }
    
    public void asignarGarageAZona(int numeroGarage,char letra)
    {
        Garage gar = getGaragePorNumero(numeroGarage);
        Zona zona = getZonaPorLetra(letra);
        gar.setZonaAsignada(zona);
        zona.addGarage(gar);
    }
    
    public void agregarAsignacionZonaEmpleadoVehiculo(AsignacionZonaEmpleadoVehiculo asZonEmVeh){
        
        asignacionesEmpleadosZonasVehiculos.add(asZonEmVeh);
    }
    
    public void agregarCompraGarage(CompraGarage compra){
        comprasGarage.add(compra);
    }
    
    
    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }

}
