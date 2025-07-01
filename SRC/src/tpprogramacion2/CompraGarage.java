package tpprogramacion2;

import java.time.LocalDate;

public class CompraGarage {
    private LocalDate fechaCompra;
    private Garage garage;
    private Socio socio;

    public CompraGarage(LocalDate fechaCompra, Garage garage, Socio socio) {
        this.fechaCompra = fechaCompra;
        this.garage = garage;
        this.socio = socio;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
    
    
}
