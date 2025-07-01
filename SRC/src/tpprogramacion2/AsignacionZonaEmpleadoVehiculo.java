package tpprogramacion2;

import tpprogramacion2.Zona;


public class AsignacionZonaEmpleadoVehiculo{
    private Zona zona;
    private Empleado empleado;
    private Vehiculo vehiculo;

    public AsignacionZonaEmpleadoVehiculo(Zona zona, Empleado empleado, Vehiculo vehiculo) {
        this.zona = zona;
        this.empleado = empleado;
        this.vehiculo = vehiculo;
    }
    
    public Zona getZona(){
        return zona;
    }
    public Empleado getEmpleado(){
        return empleado;
    }
    public Vehiculo getVehiculo(){
        return vehiculo;
    }
    
}
