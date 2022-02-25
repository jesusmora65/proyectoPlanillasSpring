
package com.proyecto.planillas.Dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Bonos implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigobono;
    
    @NotEmpty(message = "El nombre del bono es requerido")
    private String nombrebono;
    
    @NotNull(message = "La cantidad es obligatoria")
    private double cantidad;
    
    @NotEmpty(message = "El tipo de monto es requerido")
    private String tipomonto;
    
    @NotEmpty(message = "La categoría del puesto es requerida")
    private int categoriapuesto;
    
    private boolean pagoanual;
    
    private boolean carreraprofesional;
    
    private boolean estadodato;
    
    @OneToMany(mappedBy = "bono")
    private List<Montos_bonos> bonos;
}
