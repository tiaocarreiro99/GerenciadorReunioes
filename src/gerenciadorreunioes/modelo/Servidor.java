package gerenciadorreunioes.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "Servidor")
public class Servidor implements Serializable {

    private String siape;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private String area;
    private int serResponsavelAta;
    private int serCoordenador;
    private int serDe;
    private Set<Grupo> grupos = new HashSet<>();

    @Id
    @Column(name = "serSiape", nullable = false)
    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    @Column(name = "serTelefone", nullable = false)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Column(name = "serResponsavelAta", nullable = false)
    public int getSerResponsavelAta() {
        return serResponsavelAta;
    }

    public void setSerResponsavelAta(int serResponsavelAta) {
        this.serResponsavelAta = serResponsavelAta;
    }

    @Column(name = "serCoordenador", nullable = false)
    public int getSerCoordenador() {
        return serCoordenador;
    }

    public void setSerCoordenador(int serCoordenador) {
        this.serCoordenador = serCoordenador;
    }

    @Column(name = "serDe", nullable = false)
    public int getSerDe() {
        return serDe;
    }

    public void setSerDe(int serDe) {
        this.serDe = serDe;
    }

    @Column(name = "serNome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "serEmail", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "serSenha", nullable = false)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Column(name = "serArea", nullable = false)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @ManyToMany
    @JoinTable(name = "Servidor_Grupo", joinColumns = @JoinColumn(name = "seg_serSiape"), inverseJoinColumns = @JoinColumn(name = "seg_gruCodigo"))
    public Set<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }

}
