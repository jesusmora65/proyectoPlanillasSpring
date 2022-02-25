
package com.proyecto.planillas.Dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Puesto_trabajo implements Serializable {
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigopuesto;
    
    @NotEmpty(message = "El nombre del puesto es requerido")
    private String nombrepuesto;
    
    private int categoriapuesto;
    
    @Min(value = 1, message = "El salario mínimo no puede ser 0")
    @NotNull(message = "El salario base es obligatoria")
    private double salariobase;
    
    private String gradoacademicominimo;
    
    private boolean estadopuesto;
    
    @OneToMany(mappedBy = "puesto")
    private List<Empleados> empleados;
}
