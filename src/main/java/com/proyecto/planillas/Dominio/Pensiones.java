
package com.proyecto.planillas.Dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Pensiones implements Serializable {
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigopension;
    
    @NotNull(message = "El monto es requerido")
    private double montopension;
    
    @JoinColumn(name= "codigoempleado", nullable = false)
    @ManyToOne(optional = false)
    private Empleados empleado;
}
