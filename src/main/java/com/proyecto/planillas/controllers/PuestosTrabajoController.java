
package com.proyecto.planillas.controllers;

import com.proyecto.planillas.Dominio.Puesto_trabajo;
import com.proyecto.planillas.services.IServicePuestosTrabajo;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class PuestosTrabajoController {
    @Autowired
    private IServicePuestosTrabajo servicePuestosTrabajo;
    
    @GetMapping("/puestostrabajo")
    public String ListarPuestosTrabajo(Model model){
        List<Puesto_trabajo> puestostrabajo = servicePuestosTrabajo.ListarPuestosTrabajo();
        model.addAttribute("puestostrabajo", puestostrabajo);
        return "ListaPuestosTrabajo";
    }
    
    @PostMapping("/buscarpuesto")
    public String BuscarPlanillas(String buscar, Model model){
        List<Puesto_trabajo> puestostrabajo = servicePuestosTrabajo.ListarPuestosTrabajo(buscar);
        model.addAttribute("puestostrabajo", puestostrabajo);
        return "ListaPuestosTrabajo";
    }
    
    @GetMapping("/agregarpuesto")
    public String AgregarPuestoTrabajo(Puesto_trabajo puesto_trabajo){
        return "EditarPuesto";
    }
    
    @PostMapping("/guardarPuesto")
    public String GuardarPuestos(@Valid Puesto_trabajo puesto_trabajo,Errors errors){
        if(errors.hasErrors())
            return "EditarPuesto";
        servicePuestosTrabajo.GuardarPuestoTrabajo(puesto_trabajo);
        return "redirect:/puestostrabajo";
    }
    
    @GetMapping("/editarPuesto/{codigopuesto}")
    public String EditarPuestos(Puesto_trabajo puesto_trabajo,Model model){
        puesto_trabajo=servicePuestosTrabajo.ObtenerPuestoTrabajo(puesto_trabajo);
        if(puesto_trabajo!=null){
            model.addAttribute("puesto_trabajo", puesto_trabajo);
            return "EditarPuesto";
        }
        String mensaje="Imposible cargar los datos del puesto de trabajo";
        List<Puesto_trabajo> puestos=servicePuestosTrabajo.ListarPuestosTrabajo();
        model.addAttribute("puestos",puestos);
        model.addAttribute("mensaje",mensaje);
        return "ListaPuestosTrabajo";
    }
    
    @GetMapping("/deshabilitarPuesto")
    public String DeshabilitarPuesto(Puesto_trabajo puesto_trabajo){
        puesto_trabajo = servicePuestosTrabajo.ObtenerPuestoTrabajo(puesto_trabajo);
        servicePuestosTrabajo.DeshabilitarPuesto(puesto_trabajo);
        return "redirect:/puestostrabajo";
    }
}
