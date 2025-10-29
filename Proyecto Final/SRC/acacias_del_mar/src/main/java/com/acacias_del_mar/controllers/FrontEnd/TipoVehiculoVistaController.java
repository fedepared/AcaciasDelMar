package com.acacias_del_mar.controllers.FrontEnd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class TipoVehiculoVistaController {
    
    //Pagina principal
    @GetMapping({"/", "/index"})
    public String index()
    {
        log.info("Accediendo a la página principal");
        return "index";
    }
    
    @GetMapping("/tipo-vehiculos")
    public String getTipoVehiculos()
    {
        log.info("tipos de vehiculos");
        return "tipo-vehiculos";
    }
}
