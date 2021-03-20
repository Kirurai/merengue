package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "denominacion", length = 128)
    private String denominacion;

    @Column(name = "telefono", length = 50)
    private String telefono;

    @Column(name = "horario_de_atencion", length = 256)
    private String horarioDeAtencion;

    @Column(name = "quienes_somos", length = 1024)
    private String quienesSomos;

    @Column(name = "latitud")
    private double latitud;

    @Column(name = "longitud")
    private double longitud;

    @Column(name = "domicilio", length = 256)
    private String domicilio;

    @Column(name = "email", length = 75)
    private String email;

    @OneToMany(mappedBy = "empresa")
    private List<entidades.Noticia> noticias = new ArrayList<>();
}
