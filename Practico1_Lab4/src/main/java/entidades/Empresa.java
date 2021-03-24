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

    public Empresa() {
    }

    public Empresa(String denominacion, String telefono, String horarioDeAtencion, String quienesSomos, double latitud, double longitud, String domicilio, String email) {
        this.denominacion = denominacion;
        this.telefono = telefono;
        this.horarioDeAtencion = horarioDeAtencion;
        this.quienesSomos = quienesSomos;
        this.latitud = latitud;
        this.longitud = longitud;
        this.domicilio = domicilio;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorarioDeAtencion() {
        return horarioDeAtencion;
    }

    public void setHorarioDeAtencion(String horarioDeAtencion) {
        this.horarioDeAtencion = horarioDeAtencion;
    }

    public String getQuienesSomos() {
        return quienesSomos;
    }

    public void setQuienesSomos(String quienesSomos) {
        this.quienesSomos = quienesSomos;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
}
