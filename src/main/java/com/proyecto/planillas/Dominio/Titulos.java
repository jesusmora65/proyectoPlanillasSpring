
package com.proyecto.planillas.Dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Titulos implements Serializable {
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigotitulo;
    
    @NotEmpty(message = "El nombre del título es requerida")
    private String nombretitulo;
    
    @NotEmpty(message = "El nombre de la institución es requerida")
    private String nombreinstitucion;
    
    @NotNull(message = "El año es requerido")
    private int anioobtencion;
    
    @NotEmpty(message = "El grado académico es requerida")
    private String gradoacademico;
    
    @JoinColumn(name= "codigoempleado", nullable = false)
    @ManyToOne(optional = false)
    private Empleados empleado;
}
