package tpprogramacion2;

import java.util.Scanner;


public class MenuAdministrador implements Menu {

    @Override
    public boolean mostrarMenu(BaseDeDatos db, Usuario usuario) {
        Scanner teclado = new Scanner(System.in);
        Administrador usuarioCasteado = (Administrador)usuario;
        boolean cerrarMenu = false;
        while (!cerrarMenu) {

            System.out.println("******MENU DE ADMINISTRADOR " + usuario.getNombre() + "***********");
            System.out.println("[1] DAR DE ALTA SOCIO\n"
                             + "[2] DAR DE ALTA EMPLEADO\n"
                             + "[3] DAR DE ALTA ZONA\n"
                             + "[4] DAR DE ALTA GARAGE\n"
                             + "[5] REALIZAR VENTA DE GARAGE A SOCIO VEHICULO\n"
                             + "[6] ASIGNAR VEHICULO A UN GARAGE\n"
                             + "[7] ASIGNAR VEHICULO A EMPLEADO EN DETERMINADA ZONA\n"
                             + "[8] VISUALIZAR EMPLEADOS\n"
                             + "[9] VISUALIZAR SOCIOS\n"
                             + "[10] VISUALIZAR ADMINISTRADORES\n"
                             + "[11] AGREGAR ADMINISTRADOR\n"
                             + "[12] AGREGAR GARAGE A ZONA\n"
                             + "[13] SALIR DEL MENU");
            String opc = teclado.nextLine();
            switch (opc) {

                case "1":
                    Socio socio = usuarioCasteado.crearSocio();
                    db.agregarUsuario(socio);
                    break;
                case "2":
                    Empleado empleado = usuarioCasteado.crearEmpleado();
                    db.agregarUsuario(empleado);
                    break;
                case "3":
                    Zona zona = usuarioCasteado.crearZona();
                    db.agregarZona(zona);
                    break;
                case "4":
                    Garage garage = usuarioCasteado.crearGarage();
                    db.agregarGarage(garage);
                    break;
                case "5":
                    Input.mostrarMensaje("ingrese el nombre del socio");
                    String nombreUs = Input.obtenerStringNextLine();
                    Socio socioCandidato = (Socio)db.getUsuarioPorNombre(nombreUs);
                    Input.mostrarMensaje("ingrese el numero del garage");
                    int numeroGarage = Input.obtenerEntero();
                    Garage garageObtenido = db.getGaragePorNumero(numeroGarage);
                    CompraGarage compra = usuarioCasteado.comprarGarage(socioCandidato, garageObtenido);
                    db.agregarCompraGarage(compra);
                    break;
                case "6":
                    Input.mostrarMensaje("ingrese el numero del garage");
                    int numGarage = Input.obtenerEntero();
                    Garage gar = db.getGaragePorNumero(numGarage);
                    Input.mostrarMensaje("Ingrese la matricula del vehiculo: ");
                    String matricula = Input.obtenerString();
                    Vehiculo vehic = db.getVehiculoPorMatricula(matricula);
                    AsignacionVehiculoGarage asignacion = usuarioCasteado.asignarVehiculoGarage(gar, vehic);
                    db.agregarAsignacionVehiculoGarage(asignacion);
                    break;
                case "7": 
                    Input.mostrarMensaje("Ingrese la letra de la zona");
                    char letra = Input.obtenerString().charAt(0);
                    Zona zo = db.getZonaPorLetra(letra);
                    Input.mostrarMensaje("Ingrese la matricula del vehiculo: ");
                    String mat = Input.obtenerString();
                    Vehiculo ve = db.getVehiculoPorMatricula(mat);
                    Input.mostrarMensaje("Ingrese el codigo del empleado: ");
                    int codigoEmpleado = Input.obtenerEntero();
                    Empleado emple = db.getEmpleadoPorCodigoEmpleado(codigoEmpleado);
                    db.agregarAsignacionZonaEmpleadoVehiculo(new AsignacionZonaEmpleadoVehiculo(zo,emple,ve));
                case "8":
                    usuarioCasteado.getEmpleados(db.getUsuarios());
                    break;
               case "9":
                    usuarioCasteado.getSocios(db.getUsuarios());
                    break;
                case "10":
                    usuarioCasteado.getAdmins(db.getUsuarios());
                    break;
                case "11":
                    Administrador admin = usuarioCasteado.crearAdministrador();
                    db.agregarUsuario(admin);
                    break;
                case "12":
                    Input.mostrarMensaje("Ingrese el numero de garage");
                    int numGar = Input.obtenerEntero();
                    Input.mostrarMensaje("Ingrese la letra de la zona");
                    char let = Input.obtenerString().charAt(0);
                    db.asignarGarageAZona(numGar, let);
                case "13":
                    cerrarMenu = true;
                    System.out.println("CERRANDO SESION socio.....\n");
                    break;
                default:
                    System.out.println("OPCION NO VALIDA...");

            }
        }

        return cerrarMenu;
    }

}
