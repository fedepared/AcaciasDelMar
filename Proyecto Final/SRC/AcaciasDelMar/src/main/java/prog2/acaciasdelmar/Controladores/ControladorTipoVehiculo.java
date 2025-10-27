package prog2.acaciasdelmar.Controladores;

import DAOs.TipoVehiculoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorTipoVehiculo {
    
    //se agregan los DAOS
    @Autowired
    private TipoVehiculoDAO tipoVehiculoDAO;
    
    @GetMapping("/")
    //se agregan rutas de tipo get
    public String mostrarInicio(Model model){
        model.addAttribute("tipoVehiculos", tipoVehiculoDAO.getTiposVehiculos());
        return "index";
    }
    
    //se agregan rutas de tipo post
    @PostMapping("/consulta")
    public String mostrarRespuesta(
        Model model,
        @RequestParam(value = "tipoVehiculo", required = true) String color){
              //ver que se puede agregar
            //model.addAttribute("tipoVehiculo",tipoVehiculo);
            //model.addAttribute("cervezas", tipoVehiculoDAO.getTiposVehiculo(color));
            
            //return "resultado";
            return "";
    }
    
}
