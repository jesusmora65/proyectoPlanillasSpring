
package com.proyecto.planillas.controllers;

import com.proyecto.planillas.Dominio.Detalles_planilla;
import com.proyecto.planillas.Dominio.Montos_bonos;
import com.proyecto.planillas.Dominio.Montos_deducciones;
import com.proyecto.planillas.Dominio.Planilla;
import com.proyecto.planillas.services.IServiceDetalles;
import com.proyecto.planillas.services.IServicePlanilla;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class PlanillaController {
    
    @Autowired
    private IServicePlanilla servicePlanilla;
    
    @Autowired
    private IServiceDetalles serviceDetalle;
    
    @GetMapping("/planillas")
    public String ListarPlanillas(Model model){
        List<Planilla> planillas = servicePlanilla.ListarPlanillas();
        model.addAttribute("planillas", planillas);
        return "ListaPlanillas";
    }
    
    @PostMapping("/buscarplanilla")
    public String BuscarPlanillas(String tipoplanilla, Model model){
        List<Planilla> planillas = servicePlanilla.ListarPlanillas(tipoplanilla);
        model.addAttribute("planillas", planillas);
        return "ListaPlanillas";
    }
    
    @PostMapping("/calcularPlanilla")
    public String CalcularPlanilla(String tipoPlanilla, Model model){
        int resultado=servicePlanilla.GuardarPlanilla(tipoPlanilla);
        String mensaje = "";
        switch (resultado) {
            case 1:
                mensaje="Cálculo de planilla ordinaria realizado satisfactoriamente";
                break;
            case 2:
                mensaje="Cálculo de planilla extraordinaria realizado satisfactoriamente";
                break;
            case 3:
                mensaje="No se puede calcular la planilla ordinaria de este mes debido a que ya fue calculada anteriormente";
                break;
            case 4:
                mensaje="No se puede calcular la planilla extraordinaria porque no hay empleados pendientes de cálculo";
                break;
            case 5:
                mensaje="No se puede calcular la planilla porque hay empleados sin un puesto de trabajo asignado";
                break;
            default:
                mensaje="No existen empleados para calcular la planilla";
                break;
        }
        List<Planilla> planillas=servicePlanilla.ListarPlanillas();
        model.addAttribute("planillas",planillas);
        model.addAttribute("mensaje",mensaje);
        return "ListaPlanillas";
    }
    
    @GetMapping("/calculo")
    public String Agregar(Model model){
        model.addAttribute("fecha", new Date());
        return "CalcularPlanilla";
    }
    
    @GetMapping("/verDetalles{codigoplanilla}")
    public String VerDetalles(Planilla planilla, Model modelo){
        planilla = servicePlanilla.ObtenerPlanilla(planilla);
        if (planilla == null) {
            return "redirect:/planillas";
        }
        List<Detalles_planilla> detalles = planilla.getDetlles();
        modelo.addAttribute("detalles",detalles);
        return "ListaDetalles";
    }
    
    @GetMapping("/verDetallesAmpliados{codigodetalle}")
    public String VerDetallesAmpliados(Detalles_planilla detalles_planilla, Model modelo){
        detalles_planilla = serviceDetalle.ObtenerDetallePlanilla(detalles_planilla);
        if (detalles_planilla == null) {
            return "redirect:/planillas";
        }
        List<Montos_bonos> bonos = detalles_planilla.getBonos();
        List<Montos_deducciones> deducciones = detalles_planilla.getDeducciones();
        modelo.addAttribute("detalles_planilla",detalles_planilla);
        modelo.addAttribute("bonos",bonos);
        modelo.addAttribute("deducciones",deducciones);
        return "ListaDetallesAmpliados";
    }
}
