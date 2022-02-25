
package com.proyecto.planillas.services;

import com.proyecto.planillas.Dominio.Planilla;
import java.util.List;

public interface IServicePlanilla {
    public List<Planilla> ListarPlanillas();
    
    public List<Planilla> ListarPlanillas(String tipoplanilla);
    
    public Integer GuardarPlanilla(String tipoplanilla);
    
    public Planilla ObtenerPlanilla(Planilla planilla);
}
