
package com.proyecto.planillas.Dominio;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Montos_bonos implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codmontosbonos;
    
    private double montobono;
    
    @JoinColumn(name= "codigodetalle", nullable = true)
    @ManyToOne(optional = true)
    private Detalles_planilla detalle;
    
    @JoinColumn(name= "codigobono", nullable = true)
    @ManyToOne(optional = true)
    private Bonos bono;
}
