
package com.proyecto.planillas.services;

import com.proyecto.planillas.DAO.IEmpleadosDAO;
import com.proyecto.planillas.Dominio.Empleados;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceEmpleado implements IServiceEmpleado{

    @Autowired
    private IEmpleadosDAO empleadoDAO;
    
    @Override
    public List<Empleados> ListarEmpleados() {
        return (List<Empleados>) empleadoDAO.findByBorradoEquals(false);//Esto es para que no me cargue los empleados eliminados de forma lógica
    }

    @Override
    public List<Empleados> ListarEmpleados(String nombre) {
        return (List<Empleados>) empleadoDAO.findByNombreContainsOrPrimerapellidoContainsAndBorradoEquals(nombre, nombre, false);
    }

    @Transactional
    @Override
    public void GuardarEmpleado(Empleados empleado) {
        empleadoDAO.save(empleado);
    }

    @Transactional
    @Override
    public Integer EliminarEmpleado(Empleados empleado) {
        return empleadoDAO.Borrar_enpleado(empleado.getCodigoempleado());
    }

    @Override
    public Empleados ObtenerEmpleados(Empleados empleado) {
        return empleadoDAO.findById(empleado.getCodigoempleado()).orElse(null);
    }
}
