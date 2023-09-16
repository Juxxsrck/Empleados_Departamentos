package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departamento_codigo")
    private String departamentoCodigo;

    @Column(name = "departamento_nombre")
    private String departamentoNombre;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_ora_crea")
    private Date fechaHoraCrea;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora_modifica")
    private Date fechaHoraModifica;

    @PrePersist
    protected void onCreate() {
        fechaHoraCrea = new Date();
        fechaHoraModifica = fechaHoraCrea;
    }

    @PreUpdate
    protected void onUpdate(){
        fechaHoraModifica = new Date();
    }
}
