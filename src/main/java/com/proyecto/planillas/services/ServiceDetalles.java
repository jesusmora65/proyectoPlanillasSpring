
package com.proyecto.planillas.services;

import com.proyecto.planillas.DAO.IDetallesDAO;
import com.proyecto.planillas.Dominio.Detalles_planilla;
import com.proyecto.planillas.Dominio.Planilla;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDetalles implements IServiceDetalles {
    
    @Autowired
    private IDetallesDAO detallesDAO;

    @Override
    public List<Detalles_planilla> ListarDetalles(Planilla planilla, String puestoempleado) {
        return (List<Detalles_planilla>) detallesDAO.findByPlanillaAndPuestoempleadoContains(planilla, puestoempleado);
    }

    @Override
    public Detalles_planilla ObtenerDetallePlanilla(Detalles_planilla detalle) {
        return detallesDAO.findById(detalle.getCodigodetalle()).orElse(null);
    }
}
