public class Recorrido {

    public void preorden(Nodo raiz){
        if (raiz != null) {
            System.out.println(raiz.getParticipante().getFolio());
            preorden(raiz.getIzq());
            preorden(raiz.getDer());
        }
    }

    public void inorden(Nodo raiz){
        if (raiz != null) {
            inorden(raiz.getIzq());
            System.out.println(raiz.getParticipante().getFolio());
            inorden(raiz.getDer());
        }
    }

    public void postorden(Nodo raiz){
        if (raiz != null) {
            postorden(raiz.getIzq());
            postorden(raiz.getDer()); 
            System.out.println(raiz.getParticipante().getFolio());
        }
    }
}
