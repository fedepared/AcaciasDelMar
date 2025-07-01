package tpprogramacion2;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuEmpleado implements Menu {

    @Override
    public boolean mostrarMenu(BaseDeDatos db, Usuario usuario) {
        Scanner teclado = new Scanner(System.in);

        Empleado empleCasteado = (Empleado) usuario;
        boolean cerrarMenu = false;

        while (!cerrarMenu) {

            System.out.println("******MENU DE EMPLEADO " + usuario.getNombre() + "***********");
            System.out.println("[1]CONSULTAR ZONA  \n"
                    + "[2] CONSULTAR VEICULO ASIGNADO EN ZONAS \n"
                    + "[3] CONSULTAR SERVICIO DE MATENIMEINTO \n"
                    + "[4] MOSTRAR MI DATOS\n"
                    + "[5] SALIR DEL MENU");
            String opc = teclado.nextLine();
            switch (opc) {

                case "1":
                    ArrayList<AsignacionZonaEmpleadoVehiculo> asigEmplVei=db.getAsignacionesEmpleadosZonasVehiculos();
                  
                    for(AsignacionZonaEmpleadoVehiculo AsigEmVeZo : asigEmplVei){
                        
                        Empleado empl1 = AsigEmVeZo.getEmpleado();
                        
                        if(empleCasteado.getCodigo() ==empl1.getCodigo()){
                            System.out.println(empl1.toString());   
                        }      
                    }  
                    break;

                case "2":
                    ArrayList<AsignacionZonaEmpleadoVehiculo> vehiculoZona=db.getAsignacionesEmpleadosZonasVehiculos();
                     
                    for(AsignacionZonaEmpleadoVehiculo vehiZonaEmp : vehiculoZona){
                       
                        Empleado empl1 = vehiZonaEmp.getEmpleado();
                        
                        if(empleCasteado.getCodigo() ==empl1.getCodigo()){
                            
                           Vehiculo veiculoEmple = vehiZonaEmp.getVehiculo();
                           Zona zonaEmple = vehiZonaEmp.getZona();
                           
                            System.out.println(veiculoEmple.ToString());
                            System.out.println(zonaEmple.toString());
                        }   
                    }

                    break;
                case "3":
                    
                    
                    break;
                    case "4":
                        System.out.println("nombre: "+empleCasteado.getNombre());
                        System.out.println("direccion: "+ empleCasteado.getDireccion() );
                        System.out.println("telefono: "+ empleCasteado.getTelefono());
                        System.out.println("codigo empleado: "+empleCasteado.getCodigo());
                        System.out.println("especialidad: "+empleCasteado.getEspecialidad());
                    break;
                case "5":
                    cerrarMenu = true;
                    System.out.println("CERANDO SESION socio.....\n");
                    break;
                default:
                    System.out.println("OPCION NO VALIDA...");

            }
        }
        return cerrarMenu;
    }

}
