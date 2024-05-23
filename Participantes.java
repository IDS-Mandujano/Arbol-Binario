
public class Participantes {
    private int folio;
    private String nombre;
    private Boolean asistencia = false;

    public Participantes(){}
    public Participantes(int folio,String nombre,Boolean asistencia){
     this.folio = folio;
     this.nombre = nombre;
     this.asistencia = asistencia;   
    }

    public int getFolio() {
        return folio;
    }
    public String getNombre() {
        return nombre;
    }
    public Boolean getAsistencia() {
        return asistencia;
    }
}
