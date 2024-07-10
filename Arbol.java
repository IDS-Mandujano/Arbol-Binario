import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Arbol {
    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void verMenu() {
        int opc;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1.- Agregar Participantes\n2.- Registrar asistencia\n3.- Imprimir participantes\n4.- Buscar participante\n5.- Salir");
            opc = scanner.nextInt();
            scanner.nextLine();
            while (opc <= 0 || opc > 5) {
                System.out.println("Elija una opción dentro del rango");
                opc = scanner.nextInt();
            }
            validarOpc(opc);
        } while (opc != 5);
        scanner.close();
    }

    public void validarOpc(int opc) {
        switch (opc) {
            case 1:
                agregarParticipantes();
                break;
            case 2:
                registrarAsistencia();
                break;
            case 3:
                imprimirParticipantes();
                break;
            case 4:
                buscarParticipante();
                break;
            case 5: 
                salir();
                break;
        }
    }

    public void agregarParticipantes() {
        int folio;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Ingrese el folio (3 caracteres):");
            folio = scanner.nextInt();
            if (folio < 100 || folio > 999) {
                System.out.println("Error: el folio debe ser de 3 caracteres.");
            } else if (existeFolio(raiz, folio)) {
                System.out.println("Error: el folio ya existe.");
                folio = -1;
            }
        } while (folio < 100 || folio > 999);

        scanner.nextLine();

        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();

        Participantes participante = new Participantes(folio, nombre, false);
        Nodo nuevoNodo = new Nodo(participante);

        if (raiz == null) {
            raiz = nuevoNodo;
        } else {
            crearArbol(raiz, nuevoNodo);
        }
    }

    public boolean existeFolio(Nodo nodo, int folio) {
        if (nodo == null) {
            return false;
        }
        if (nodo.getParticipante().getFolio() == folio) {
            return true;
        }
        if (folio < nodo.getParticipante().getFolio()) {
            return existeFolio(nodo.getIzq(), folio);
        } else {
            return existeFolio(nodo.getDer(), folio);
        }
    }

    public void crearArbol(Nodo actual, Nodo nuevoNodo) {
        if (nuevoNodo.getParticipante().getFolio() < actual.getParticipante().getFolio()) {
            if (actual.getIzq() == null) {
                actual.setIzq(nuevoNodo);
            } else {
                crearArbol(actual.getIzq(), nuevoNodo);
            }
        } else {
            if (actual.getDer() == null) {
                actual.setDer(nuevoNodo);
            } else {
                crearArbol(actual.getDer(), nuevoNodo);
            }
        }
    }

    public void registrarAsistencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el folio del participante para registrar la asistencia:");
        int folio = scanner.nextInt();
        scanner.nextLine();

        Nodo nodo = buscarNodo(raiz, folio);
        if (nodo != null) {
            Boolean asistencia = obtenerAsistencia();
            nodo.getParticipante().setAsistencia(asistencia);
            System.out.println("Asistencia registrada para el folio: " + folio);
        } else {
            System.out.println("Participante con folio " + folio + " no encontrado.");
        }
    }

    public Nodo buscarNodo(Nodo nodo, int folio) {
        if (nodo == null || nodo.getParticipante().getFolio() == folio) {
            return nodo;
        }
        if (folio < nodo.getParticipante().getFolio()) {
            return buscarNodo(nodo.getIzq(), folio);
        } else {
            return buscarNodo(nodo.getDer(), folio);
        }
    }

    public Boolean obtenerAsistencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Asistió\n1.- Sí\n2.- No");
        int opc = scanner.nextInt();
        scanner.nextLine();
        return opc == 1;
    }

    public void imprimirParticipantes() {
        imprimirParticipantes(raiz);
    }

    public void imprimirParticipantes(Nodo nodo) {
        Recorrido r = new Recorrido();
        if (nodo != null) {
            r.inorden(nodo);
        }
    }

    public void buscarParticipante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el folio del participante a buscar:");
        int folio = scanner.nextInt();
        scanner.nextLine();

        Recorrido recorrido = new Recorrido();
        int resultado = -1;

        resultado = recorrido.inorden(raiz, folio);

        if (resultado != -1) {
            System.out.println("Participante con folio " + folio + " encontrado.");
        } else {
            System.out.println("Participante con folio " + folio + " no encontrado.");
        }
    }

    public void guardarParticipantesEnArchivo() {
        try (FileWriter asistieronWriter = new FileWriter("asistieron.txt");
             FileWriter noAsistieronWriter = new FileWriter("no_asistieron.txt")) {
            guardarParticipantesEnArchivo(raiz, asistieronWriter, noAsistieronWriter);
            System.out.println("Información de los participantes guardada en los archivos.");
        } catch (IOException e) {
            System.out.println("Error al guardar la información en el archivo: " + e.getMessage());
        }
    }

    public void guardarParticipantesEnArchivo(Nodo nodo, FileWriter asistieronWriter, FileWriter noAsistieronWriter) throws IOException {
        if (nodo != null) {
            guardarParticipantesEnArchivo(nodo.getIzq(), asistieronWriter, noAsistieronWriter);
            String info = "Folio: " + nodo.getParticipante().getFolio() +
                    ", Nombre: " + nodo.getParticipante().getNombre() + "\n";
            if (nodo.getParticipante().getAsistencia()) {
                asistieronWriter.write(info);
            } else {
                noAsistieronWriter.write(info);
            }
            guardarParticipantesEnArchivo(nodo.getDer(), asistieronWriter, noAsistieronWriter);
        }
    }

    public void salir() {
        guardarParticipantesEnArchivo();
        System.out.println("Saliendo del programa.");
    }
}
