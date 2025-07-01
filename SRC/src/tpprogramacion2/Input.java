package tpprogramacion2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Input {

    public static LocalDate obtenerFecha() {

        Scanner teclado = new Scanner(System.in);
        LocalDate fechaLd;
        String fecha;
        System.out.println("ingrese fecha en fotmato aaaa/mm/dd");
        fecha = teclado.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        fechaLd = LocalDate.parse(fecha, formatter);
        return fechaLd;

    }

    public static LocalDate obtenerFecha(String fecha) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate fechaLd = LocalDate.parse(fecha, formatter);
        return fechaLd;
    }

    public static int obtenerEntero() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }
    
    public static double obtenerDouble() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    public static String obtenerString() {
        Scanner teclado = new Scanner(System.in);

        return teclado.next();
    }
    public static String obtenerStringNextLine() {
        Scanner teclado = new Scanner(System.in);

        return teclado.nextLine();
    }

    public static void mostrarMensaje(String msj) {

        System.out.println(msj);

    }
}
