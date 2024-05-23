public class Recorrido {

    public void preorden(Nodo nodo){
        if (nodo != null) {
            System.out.println("Folio: " + nodo.getParticipante().getFolio()+
                 ", Nombre: " + nodo.getParticipante().getNombre()+ 
                 ", Asistencia: " +(nodo.getParticipante().getAsistencia() ? "Sí" : "No"));
            preorden(nodo.getIzq());
            preorden(nodo.getDer());
        }
    }

    public void inorden(Nodo nodo){
        if (nodo != null) {
            inorden(nodo.getIzq());
            System.out.println("Folio: " + nodo.getParticipante().getFolio()+
                 ", Nombre: " + nodo.getParticipante().getNombre()+ 
                 ", Asistencia: " +(nodo.getParticipante().getAsistencia() ? "Sí" : "No"));
            inorden(nodo.getDer());
        }
    }

    public void postorden(Nodo nodo){
        if (nodo != null) {
            postorden(nodo.getIzq());
            postorden(nodo.getDer());
            System.out.println("Folio: " + nodo.getParticipante().getFolio()+
                 ", Nombre: " + nodo.getParticipante().getNombre()+ 
                 ", Asistencia: " +(nodo.getParticipante().getAsistencia() ? "Sí" : "No"));
        }
    }
}
