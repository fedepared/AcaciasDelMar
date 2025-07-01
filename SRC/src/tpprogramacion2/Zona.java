package tpprogramacion2;

import java.util.ArrayList;


public class Zona {
    private char nombre;
    private ArrayList<String> tipoVehiculosAdmitidos;
    private static int cantidadVehiculosAsignados;
    private static ArrayList<Garage> garagesAsignados;
    
    public Zona(char nombre){
        this.nombre = nombre;
        tipoVehiculosAdmitidos = new ArrayList<String>();
        cantidadVehiculosAsignados = 0;
    }
    
    public Zona(char nombre,ArrayList<String> tipoVehiculosAdmitidos){
        this.nombre = nombre;
        this.tipoVehiculosAdmitidos = tipoVehiculosAdmitidos;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + " tipoVehiculosAdmitidos" + tipoVehiculosAdmitidos +" ";
    }
    
    public void sumarUnVehiculoAsignado(){
        cantidadVehiculosAsignados++;
    }
    
    public void addGarage(Garage garage){
        garagesAsignados.add(garage);
    }
    
    public char getLetra(){
        return nombre;
    }
    
    
}
