package tpprogramacion2;

import tpprogramacion2.Zona;

public class Garage {
    private int numeroGarage;
    private double lecturaContadorLuz;
    private boolean servicioMantenimientoContratado;
    private double profundidad;
    private double ancho;
    private Zona zonaAsignada;
    
    public Garage(int numeroGarage,double lecturaContadorLuz,boolean servicioMantenimientoContratado,double profundidad,double ancho){
        this.numeroGarage = numeroGarage;
        this.lecturaContadorLuz = lecturaContadorLuz;
        this.servicioMantenimientoContratado = servicioMantenimientoContratado;
        this.profundidad = profundidad;
        this.ancho = ancho;
    }

    public int getNumeroGarage() {
        return numeroGarage;
    }

    public boolean isServicioMantenimientoContratado() {
        return servicioMantenimientoContratado;
    }
    
    public void setZonaAsignada(Zona zona){
        zonaAsignada = zona;
    }
    
    public int getNumero(){
        return numeroGarage;
    }
    
    public Zona getZonaAsignada(){
        return zonaAsignada;
    }
}
