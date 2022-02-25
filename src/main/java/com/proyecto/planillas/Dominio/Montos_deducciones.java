
package com.proyecto.planillas.Dominio;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Montos_deducciones implements Serializable {
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codmontosdeducciones;
    
    private double montodeduccion;
    
    @JoinColumn(name= "codigodetalle", nullable = true)
    @ManyToOne(optional = true)
    private Detalles_planilla detalle;
    
    @JoinColumn(name= "codigodeduccion", nullable = true)
    @ManyToOne(optional = true)
    private Deducciones deduccion;
}
