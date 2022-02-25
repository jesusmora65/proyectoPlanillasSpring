
package com.proyecto.planillas.Dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Planilla implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoplanilla;
    
    private int mesplanilla;
    
    private int anioplanilla;
    
    private String tipoplanilla;
    
    private boolean anulada;
    
    private boolean cancelada;
    
    @OneToMany(mappedBy = "planilla")
    private List<Detalles_planilla> detlles;
}
