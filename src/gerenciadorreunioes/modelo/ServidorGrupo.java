package gerenciadorreunioes.modelo;
// Generated 16/09/2016 10:50:07 by Hibernate Tools 4.3.1



/**
 * ServidorGrupo generated by hbm2java
 */
public class ServidorGrupo  implements java.io.Serializable {


     private Integer segCodigo;
     private Grupo grupo;
     private Servidor servidor;

    public ServidorGrupo() {
    }

    public ServidorGrupo(Grupo grupo, Servidor servidor) {
       this.grupo = grupo;
       this.servidor = servidor;
    }
   
    public Integer getSegCodigo() {
        return this.segCodigo;
    }
    
    public void setSegCodigo(Integer segCodigo) {
        this.segCodigo = segCodigo;
    }
    public Grupo getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    public Servidor getServidor() {
        return this.servidor;
    }
    
    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }




}


