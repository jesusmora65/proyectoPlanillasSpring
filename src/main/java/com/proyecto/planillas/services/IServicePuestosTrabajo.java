
package com.proyecto.planillas.services;

import com.proyecto.planillas.Dominio.Puesto_trabajo;
import java.util.List;

public interface IServicePuestosTrabajo {
    public List<Puesto_trabajo> ListarPuestosTrabajo();
    
    public List<Puesto_trabajo> ListarPuestosTrabajo(String buscar);
    
    public void GuardarPuestoTrabajo(Puesto_trabajo puestotrabajo);
    
    public void DeshabilitarPuesto(Puesto_trabajo puestotrabajo);
    
    public Puesto_trabajo ObtenerPuestoTrabajo(Puesto_trabajo puestotrabajo);
}
