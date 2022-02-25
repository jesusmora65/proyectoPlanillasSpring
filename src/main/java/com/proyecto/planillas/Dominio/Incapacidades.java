
package com.proyecto.planillas.Dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
public class Incapacidades implements Serializable {
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoincapacidad;
    
    @NotEmpty(message = "La fecha de inicio es requerida")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar fechainicio;
    
    @NotEmpty(message = "La fecha de fin es requerida")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar fechafin;
    
    @JoinColumn(name= "codigoempleado", nullable = false)
    @ManyToOne(optional = false)
    private Empleados empleado;
}
