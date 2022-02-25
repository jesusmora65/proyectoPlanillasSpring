
package com.proyecto.planillas.services;

import com.proyecto.planillas.Dominio.Detalles_planilla;
import com.proyecto.planillas.Dominio.Planilla;
import java.util.List;

public interface IServiceDetalles {
    public List<Detalles_planilla> ListarDetalles(Planilla planilla, String puestoempleado);

    public Detalles_planilla ObtenerDetallePlanilla(Detalles_planilla detalle);
}
