
package com.proyecto.planillas.services;

import com.proyecto.planillas.DAO.IPuestosTrabajoDAO;
import com.proyecto.planillas.Dominio.Puesto_trabajo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicePuestosTrabajo implements IServicePuestosTrabajo{
    
    @Autowired
    private IPuestosTrabajoDAO puestoTrabajoDAO;

    @Override
    public List<Puesto_trabajo> ListarPuestosTrabajo() {
        return (List<Puesto_trabajo>) puestoTrabajoDAO.findByEstadopuesto(false);
    }

    @Override
    public List<Puesto_trabajo> ListarPuestosTrabajo(String buscar) {
        return (List<Puesto_trabajo>) puestoTrabajoDAO.findByNombrepuestoContainsOrGradoacademicominimoContainsAndEstadopuesto(buscar, buscar, false);
    }

    @Transactional
    @Override
    public void GuardarPuestoTrabajo(Puesto_trabajo puestotrabajo) {
        puestoTrabajoDAO.save(puestotrabajo);
    }

    @Override
    public Puesto_trabajo ObtenerPuestoTrabajo(Puesto_trabajo puestotrabajo) {
        return puestoTrabajoDAO.findById(puestotrabajo.getCodigopuesto()).orElse(null);
    }

    @Transactional
    @Override
    public void DeshabilitarPuesto(Puesto_trabajo puestotrabajo) {
        puestotrabajo.setEstadopuesto(true);
        puestoTrabajoDAO.save(puestotrabajo);
    }
}
