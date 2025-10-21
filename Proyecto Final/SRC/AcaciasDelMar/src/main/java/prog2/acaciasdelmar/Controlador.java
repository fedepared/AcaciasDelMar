package prog2.acaciasdelmar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {
    
    //se agregan los DAOS
    @Autowired
    //private CervezasDAO cervezasDAO;
    
    @GetMapping("/")
    //se agregan rutas de tipo get
    public String mostrarInicio(Model model){
//        model.addAttribute("colores", cervezasDAO.getColores());
//        return "index";
          return "";
    }
    
    //se agregan rutas de tipo post
    @PostMapping("/consulta")
    public String mostrarRespuesta(
        Model model,
        @RequestParam(value = "color", required = true) String color){
              //ver que se puede agregar
//            model.addAttribute("colorElegido",color);
//            model.addAttribute("cervezas", cervezasDAO.getCervezasByColor(color));
            
            //return "resultado";
            return "";
    }
    
}
