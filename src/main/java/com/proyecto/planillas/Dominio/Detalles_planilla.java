
package com.proyecto.planillas.Dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Detalles_planilla implements Serializable {
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigodetalle;
    
    private double salariobase;
    
    private double montobonos;
    
    private double salariobruto;
    
    private double montodeducciones;
    
    private double salarioneto;
    
    private String puestoempleado;
    
    @JoinColumn(name= "codigoempleado", nullable = false)
    @ManyToOne(optional = false)
    private Empleados empleado;
    
    @JoinColumn(name= "codigoplanilla", nullable = false)
    @ManyToOne(optional = false)
    private Planilla planilla;
    
    @OneToMany(mappedBy = "detalle")
    private List<Montos_deducciones> deducciones;
    
    @OneToMany(mappedBy = "detalle")
    private List<Montos_bonos> bonos;
}
