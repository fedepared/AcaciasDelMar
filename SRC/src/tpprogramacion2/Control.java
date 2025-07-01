package tpprogramacion2;

import java.util.Scanner;
import javax.naming.AuthenticationException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Control {

    private BaseDeDatos db;
    //private boolean sistemaActivo;
    // private Scanner teclado;

    public Control() {
        this.db = new BaseDeDatos();
        //this.teclado = new Scanner(System.in);
        //  this.sistemaActivo = true;

    }

    public void IniciarSistema() {
        Scanner teclado = new Scanner(System.in);
        boolean SalirDelSistema = false;
         Usuario usuario = null;
        boolean esta = false;
        do {

            
                System.out.println("\n****SISTEMA DE LOGIN GUARDERIA****");
                System.out.println("Usuario");
                String user = teclado.nextLine();
                System.out.println("Contraseña");
                String pws = teclado.nextLine();

                usuario = db.Autentificar(user, pws);
                if (usuario == null) {
                    System.out.println("Error usuario no encontrado intente de nuevo");
                }
                else{
                    Programa programa = new Programa(usuario);
                    Menu menu = crearMenu(usuario);
                    programa.login(menu, db);

                    System.out.println("\n que deas hacer  ahora?");
                    System.out.println("[1] Cambiar de usuario");
                    System.out.println("[2] Salir del sistema ");
                    System.out.println("opcion");
                    String opc= teclado.nextLine();
                    if(opc.equals("2")){
                        SalirDelSistema=true;
                    }        
                }
        } while (!SalirDelSistema);
        teclado.close();
        System.out.println("SISTEMA DE GUARDERIA CERRADO CORECTAMENTE");

    }

   

    private Menu crearMenu(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser null");
        }
        return switch (usuario.getTipoUsuario()) {
            case "ADMINISTRADOR" ->
                new MenuAdministrador();

            case "EMPLEADO" ->
                new MenuEmpleado();

            case "SOCIO" ->
                new MenuSocio();

            default ->
                throw new IllegalArgumentException("Tipo de usuario no válido");

        };
    }
  }