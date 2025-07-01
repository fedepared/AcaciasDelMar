/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpprogramacion2;

/**
 *
 * @author hector mc
 */
public class Empleado extends Usuario{
    
    private int codigoEmpleado;
    private String especialidad;

    public Empleado(int codigoEmpleado, String Especialidad, String nombre, String direccion, int dni, int telefono, String usuario, String password) {
        super(nombre, direccion, dni, telefono, usuario, password);
        this.codigoEmpleado = codigoEmpleado;
        this.especialidad = Especialidad;
    }

    public String empleadoToString(){
        String datos = "codigo de empleado: "+codigoEmpleado+"\n"+"especialidad: "+especialidad+"\n";
        return usuarioToString()+datos;
    }
   
    public int getCodigo(){
        return codigoEmpleado;
    }

    public String getEspecialidad() {
        return especialidad;
    }
  
    @Override
    public String getTipoUsuario() {
        return "EMPLEADO";
    }
    
}
