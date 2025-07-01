package tpprogramacion2;

import java.time.LocalDate;
import java.util.logging.Logger;

public class AsignacionVehiculoGarage {

    private LocalDate fechaAsignacion;
    private Garage garage;
    private Vehiculo vehiculo;

    public AsignacionVehiculoGarage(LocalDate fechaAsignacion, Garage garage, Vehiculo vehiculo) {
        this.fechaAsignacion = fechaAsignacion;
        this.garage = garage;
        this.vehiculo = vehiculo;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public Garage getGarage() {
        return garage;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    private static final Logger LOG = Logger.getLogger(AsignacionVehiculoGarage.class.getName());

}
