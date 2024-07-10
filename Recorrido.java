public class Recorrido {

    public int preorden(Nodo nodo, int folio) {
        if (nodo == null) {
            return -1;
        }

        int valorCentral = nodo.getParticipante().getFolio();
        if (folio == valorCentral) {
            return valorCentral;
        } else if (folio < valorCentral) {
            return preorden(nodo.getIzq(), folio);
        } else {
            return preorden(nodo.getDer(), folio);
        }
    }

    public int inorden(Nodo nodo, int folio) {
        if (nodo == null) {
            return -1;
        }

        int resultado = inorden(nodo.getIzq(), folio);
        if (resultado != -1) {
            return resultado;
        }

        int valorCentral = nodo.getParticipante().getFolio();
        if (folio == valorCentral) {
            return valorCentral;
        }

        return inorden(nodo.getDer(), folio);
    }

    public int postorden(Nodo nodo, int folio) {
        if (nodo == null) {
            return -1;
        }

        int resultado = postorden(nodo.getIzq(), folio);
        if (resultado != -1) {
            return resultado;
        }

        resultado = postorden(nodo.getDer(), folio);
        if (resultado != -1) {
            return resultado;
        }

        int valorCentral = nodo.getParticipante().getFolio();
        if (folio == valorCentral) {
            return valorCentral;
        }

        return -1;
    }

    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.getIzq());
            System.out.println("Folio: " + nodo.getParticipante().getFolio() +
                    ", Nombre: " + nodo.getParticipante().getNombre() +
                    ", Asistencia: " + (nodo.getParticipante().getAsistencia() ? "Sí" : "No"));
            inorden(nodo.getDer());
        }
    }
}
