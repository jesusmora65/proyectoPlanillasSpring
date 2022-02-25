
package com.proyecto.planillas.Dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Datos_desglosados implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigodato;
    
    @NotEmpty(message = "La descripción es requerida")
    private String descripcion;
    
    @NotNull(message = "El monto mínimo es obligatoria")
    private double montomminimo;
    
    @NotNull(message = "El monto máximo es obligatoria")
    private double montommaximo;
    
    @NotNull(message = "El porcentaje es obligatoria")
    private int porcentaje;
    
    @JoinColumn(name = "codigodeduccion", nullable = false)
    @ManyToOne(optional = false)
    private Deducciones deduccion;
}
