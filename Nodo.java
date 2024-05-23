class Nodo {
    private Participantes participante;
    private Nodo izq;
    private Nodo der;

    public Nodo(Participantes participante) {
        this.participante = participante;
        this.izq = null;
        this.der = null;
    }

    public Participantes getParticipante() {
        return participante;
    }

    public void setParticipante(Participantes participante) {
        this.participante = participante;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
}