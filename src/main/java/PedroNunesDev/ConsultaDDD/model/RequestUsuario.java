package PedroNunesDev.ConsultaDDD.model;

import jakarta.persistence.*;

@Entity
public class RequestUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "request", nullable = false)
    private String request;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
