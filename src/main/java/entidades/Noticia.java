package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "noticia")
public class Noticia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo", length = 128)
    private String titulo;

    @Column(name = "resumen", length = 1024)
    private String resumen;

    @Column(name = "imagen", length = 128)
    private String imagen;

    @Column(name = "contenido_HTML", length = 20480)
    private String contenidoHTML;

    @Column(name = "publicada")
    private char publicada;

    @Column(name = "fecha_publicacion")
    private Date fechaPublicacion;

    @ManyToOne(cascade = CascadeType.PERSIST) //si se borra la noticia, no se borra la empresa
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public Noticia() {
    }

    public Noticia(String titulo, String resumen, String imagen, String contenidoHTML, char publicada, Date fechaPublicacion, Empresa empresa) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.imagen = imagen;
        this.contenidoHTML = contenidoHTML;
        this.publicada = publicada;
        this.fechaPublicacion = fechaPublicacion;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getContenidoHTML() {
        return contenidoHTML;
    }

    public void setContenidoHTML(String contenidoHTML) {
        this.contenidoHTML = contenidoHTML;
    }

    public char getPublicada() {
        return publicada;
    }

    public void setPublicada(char publicada) {
        this.publicada = publicada;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
