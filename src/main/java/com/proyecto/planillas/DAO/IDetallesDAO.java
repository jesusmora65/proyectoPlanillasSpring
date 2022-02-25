
package com.proyecto.planillas.DAO;

import com.proyecto.planillas.Dominio.Detalles_planilla;
import com.proyecto.planillas.Dominio.Planilla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetallesDAO extends JpaRepository<Detalles_planilla, Long> {
    public Iterable<Detalles_planilla> findByPlanillaAndPuestoempleadoContains(Planilla planilla, String puestoempleado);
}
