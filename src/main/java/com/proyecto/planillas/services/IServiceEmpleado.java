
package com.proyecto.planillas.services;

import com.proyecto.planillas.Dominio.Empleados;
import java.util.List;

public interface IServiceEmpleado {
    public List<Empleados> ListarEmpleados();
    
    public List<Empleados> ListarEmpleados(String nombre);
    
    public void GuardarEmpleado(Empleados empleado);
    
    public Integer EliminarEmpleado(Empleados empleado);
    
    public Empleados ObtenerEmpleados(Empleados empleado);
}
