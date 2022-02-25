
package com.proyecto.planillas.DAO;

import com.proyecto.planillas.Dominio.Puesto_trabajo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPuestosTrabajoDAO extends JpaRepository<Puesto_trabajo, Long>{
    public Iterable<Puesto_trabajo> findByEstadopuesto(boolean estadopuesto);
    
    public Iterable<Puesto_trabajo> findByNombrepuestoContainsOrGradoacademicominimoContainsAndEstadopuesto(String nombrepuesto, String gradoacademicominimo, boolean estadopuesto);
}
