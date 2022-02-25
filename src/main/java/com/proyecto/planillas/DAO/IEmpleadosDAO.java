
package com.proyecto.planillas.DAO;

import com.proyecto.planillas.Dominio.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IEmpleadosDAO extends JpaRepository<Empleados, Long>{
    public Iterable<Empleados> findByBorradoEquals(boolean borrado);
    
    public Iterable<Empleados> findByNombreContainsOrPrimerapellidoContainsAndBorradoEquals(String mombre, String primerApellido, boolean borrado);
    
    @Transactional
    @Procedure(name = "BORRAR_EMPLEADO", outputParameterName = "retorno")
    public Integer Borrar_enpleado(@Param("codigoEmpleado") long codigoEmpleado);
}
