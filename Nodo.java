public class Nodo {
    private Participantes participante = new Participantes();
    private Nodo izq;
    private Nodo der;

    public Nodo(Participantes participante){
        this.participante = participante;
    }

    public Nodo(){}
    public Nodo getIzq() {
        return izq;
    }

    public Nodo getDer() {
        return der;
    }

    public Participantes getParticipante() {
        return participante;
    }

    public void setParticipante(Participantes participante) {
        this.participante = participante;
    }

    public void setIzq(Nodo nodo) {
        this.izq = nodo;
    }

    public void setDer(Nodo nodo) {
        this.der = nodo;
    }
}