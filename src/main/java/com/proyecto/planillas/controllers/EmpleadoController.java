
package com.proyecto.planillas.controllers;

import com.proyecto.planillas.Dominio.Empleados;
import com.proyecto.planillas.services.IServiceEmpleado;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class EmpleadoController {
    
    @Autowired
    private IServiceEmpleado serviceEmpleado;
    
    @GetMapping("/empleados")
    public String ListarEmpleados(Model model){
        List<Empleados> empleados = serviceEmpleado.ListarEmpleados();
        model.addAttribute("empleados", empleados);
        return "ListaEmpleados";
    }
    
    @PostMapping("/buscarempleado")
    public String BuscarEmpleado(String nombre, Model model){
        List<Empleados> empleados = serviceEmpleado.ListarEmpleados(nombre);
        model.addAttribute("empleados", empleados);
        return "ListaEmpleados";
    }
}
