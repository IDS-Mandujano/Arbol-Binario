import java.util.Scanner;

public class Arbol {
    public void verMenu(){
        int opc;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1.-Agregar Participantes\n2.-Imprimir participantes\n3.-Salir");
            opc = scanner.nextInt();
        } while (opc!=3);
    }

    public void validarOpc(int opc){
        switch (opc) {
            case 1:
                agregarParticipantes();
                break;
            case 2:
                imprimirParticipantes();
                break;
            case 3:
                salir();
                break;
        }
    }

    public void agregarParticipantes(){
        Scanner scanner = new Scanner(System.in);
        Nodo raiz = new Nodo();
        int folio;
        String nombre;

        System.out.println("Ingrese el folio");
        folio = scanner.nextInt();

        System.out.println("Ingrese su nombre");
        nombre = scanner.nextLine();

        Participantes participante = new Participantes(folio, nombre, registrarAsistencia());
        raiz.setParticipante(participante);
    }

    public void crearArbol(Nodo nodo){
        
        
    }

    public Boolean registrarAsistencia(){
        Scanner scanner = new Scanner(System.in);

        Boolean asistencia= false ;
        int opc;

        System.out.println("Asistio\n1.-Si\n2.-No");
        opc = scanner.nextInt();
        if (opc==1) {
            return asistencia = true;
        }

        return asistencia;
    }

    public void imprimirParticipantes(){
    }

    public void salir(){

    }
}
