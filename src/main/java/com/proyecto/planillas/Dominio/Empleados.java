
package com.proyecto.planillas.Dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
public class Empleados implements Serializable {
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoempleado;
    
    @NotEmpty(message = "La identificación es requerida")
    private String identificacion;
    
    @NotEmpty(message = "La fecha de nacimiento es requerida")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar fechanacimiento;
    
    @NotEmpty(message = "El nombre es requerido")
    private String nombre;
    
    @NotEmpty(message = "El primer apellido es requerido")
    private String primerapellido;
    
    private String segundoapellido;
    
    @NotEmpty(message = "El teléfono es requerido")
    private String telefono;
    
    @Email
    @NotEmpty(message = "El correo es requerido")
    private String correo;
    
    @NotEmpty(message = "La dirección es requerida")
    private String direccion;
    
    @JoinColumn(name= "codigopuesto", nullable = true)
    @ManyToOne(optional = true)
    private Puesto_trabajo puesto;
    
    @NotEmpty(message = "La fecha de ingreso es requerida")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar fechaingreso;
    
    private boolean borrado;
    
    private String carrerabase;
    
    private int puntoscarrera;
    
    @OneToMany(mappedBy = "empleado")
    private List<Detalles_planilla> detalles;
    
    @OneToMany(mappedBy = "empleado")
    private List<Pensiones> pensiones;
    
    @OneToMany(mappedBy = "empleado")
    private List<Incapacidades> incapacidades;;
    
    @OneToMany(mappedBy = "empleado")
    private List<Titulos> titulos;
}
