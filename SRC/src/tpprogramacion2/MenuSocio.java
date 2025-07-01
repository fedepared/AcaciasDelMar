/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpprogramacion2;

/**
 *
 * @author hector mc
 */
import java.util.ArrayList;
import java.util.Scanner;

public class MenuSocio implements Menu {

    @Override
    public boolean mostrarMenu(BaseDeDatos db, Usuario usuario) {
        Scanner teclado = new Scanner(System.in);
        Socio socioCasteado = (Socio) usuario;
        boolean cerrarMenu = false;

        while (!cerrarMenu) {

            System.out.println("******MENU DE SOCIO " + usuario.getNombre() + "*******");
            System.out.println("[1] CONSULTAR  MI VEICULOS \n"
                    + "[2] CONSULTAR MI GARAJE \n"
                    + "[3] MOSTRAR MI DATOS\n"
                    + "[4] SALIR DEL MENU");
            String opc = teclado.nextLine();
            switch (opc) {

                case "1":
                    
                    // cargo en desde la base de datos en  un ArrayList de listDeAsigna 
                     ArrayList<AsignacionVehiculoGarage> listDeAsigna = db.getAsignacionesVehicGarage();

                    System.out.println("LISTA DE VEHICULO DE SOCIO");
                    //recoro todad las asignaciones 
                    for (AsignacionVehiculoGarage ListAsignaVeil : listDeAsigna) {
                        // copio un veiculo  de la ListAsignaVeil
                     Vehiculo vehiculo= ListAsignaVeil.getVehiculo();
                     // tomo solo la maatricula
                     String MatriculaVeiculo=vehiculo.getMatricula();
                     ///tomo la lista de socio 
                      ArrayList<Vehiculo> veiculoSocio = socioCasteado.getVehiculos() ;
                      
                      for(Vehiculo viculoSoci : veiculoSocio){
                         // comopar la matricula de la base de datos  
                         // la lista de socio que tine viculo 
                         if(MatriculaVeiculo == viculoSoci.getMatricula()){
                              
                             System.out.println("fecha cuanse se le asigno el veiculo " +ListAsignaVeil.getFechaAsignacion()); 
                              System.out.println(viculoSoci.ToString());
                              
                          }
                      }    
                     
                       
                    }
                    break;
                case "2":

                    ArrayList<CompraGarage> ListaCompras = db.getComprasGarage();
                    System.out.println("MIS GARAJES");
                    for (CompraGarage cp : ListaCompras) {
                        int dueno = socioCasteado.getDni();
                        if (dueno == cp.getSocio().getDni()) {
                            System.out.println(" fecha de compra de gaeaje" + cp.getFechaCompra());
                            System.out.println(" numero del garage " + cp.getGarage().getNumeroGarage());
                            System.out.println(" el garaje tiene un ancho " + cp.getGarage().isServicioMantenimientoContratado());
                        }

                    }

                    break;

                case "3":

                    System.out.println("MOSTRAR MIS DATOS");
                    System.out.println("nombre: " + socioCasteado.getNombre());
                    System.out.println("direccion: " + socioCasteado.getDireccion());
                    System.out.println("telefono: " + socioCasteado.getTelefono());

                    break;
                case "4":
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
