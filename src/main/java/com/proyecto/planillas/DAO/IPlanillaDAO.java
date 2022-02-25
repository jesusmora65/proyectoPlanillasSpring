
package com.proyecto.planillas.DAO;

import com.proyecto.planillas.Dominio.Planilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IPlanillaDAO extends JpaRepository<Planilla, Long> {
    public Iterable<Planilla> findByAnulada(boolean anulada);
    
    public Iterable<Planilla> findByTipoplanillaAndAnulada(String tipoplanilla, boolean anulada);
    
    @Transactional
    @Procedure(name = "CALCULAR_PLANILLAS", outputParameterName = "retorno")
    public Integer CALCULAR_PLANILLAS(@Param("tipoPlanilla") String tipoPlanilla);
}
