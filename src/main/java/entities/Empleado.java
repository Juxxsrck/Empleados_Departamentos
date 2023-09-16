package entities;

import lombok.Cleanup;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "documento_tipo")
    private String documentoTipo;

    @Column(name = "documento_numero")
    private String documentoNumero;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora_crea")
    private Date fechaHoracrea;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora_modifica")
    private Date fechaHoraModifica;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
}
