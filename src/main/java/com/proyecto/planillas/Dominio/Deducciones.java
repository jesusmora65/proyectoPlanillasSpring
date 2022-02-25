
package com.proyecto.planillas.Dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Deducciones implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigodeduccion;
    
    @NotEmpty(message = "El nombre es requerido")
    private String nombrededuccion;
    
    @NotNull(message = "La cantidad es obligatoria")
    private int cantidad;
    
    @NotEmpty(message = "El tipo de monto es requerido")
    private String tipomonto;
    
    @NotEmpty(message = "La categoría del puesto es requerida")
    private int categoriapuesto;
    
    private boolean pagoanual;
    
    private boolean pension;
    
    private boolean estadodato;
    
    @OneToMany(mappedBy = "deduccion")
    private List<Datos_desglosados> datos;
    
    @OneToMany(mappedBy = "deduccion")
    private List<Montos_deducciones> deducciones;
}
