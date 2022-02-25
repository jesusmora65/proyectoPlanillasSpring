
package com.proyecto.planillas.services;

import com.proyecto.planillas.DAO.IPlanillaDAO;
import com.proyecto.planillas.Dominio.Planilla;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePlanilla implements IServicePlanilla{
    
    @Autowired
    private IPlanillaDAO planillaDAO;

    @Override
    public List<Planilla> ListarPlanillas() {
        return (List<Planilla>) planillaDAO.findByAnulada(false);
    }

    @Override
    public List<Planilla> ListarPlanillas(String tipoplanilla) {
        return (List<Planilla>) planillaDAO.findByTipoplanillaAndAnulada(tipoplanilla, false);
    }

    @Override
    public Integer GuardarPlanilla(String tipoplanilla) {
        return planillaDAO.CALCULAR_PLANILLAS(tipoplanilla);
    }

    @Override
    public Planilla ObtenerPlanilla(Planilla planilla) {
        return planillaDAO.findById(planilla.getCodigoplanilla()).orElse(null);
    }
}
