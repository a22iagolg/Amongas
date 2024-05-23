package src;

import java.util.ArrayList;
import java.util.Scanner;
import Menu.*;

public class App {

    public static long tMax = 8000;

    public static long gettMax() {
        return tMax;
    }

    public static void settMax(long tMax) {
        App.tMax = tMax;
    }

    public static Scanner getScanner() {
        if (sc == null) {
            sc = new Scanner(System.in);
        }
        return sc;
    }
    ///Ese

    private static Scanner sc = getScanner();

    public static void main(String[] args) {
        ArrayList<Tarefa> listaTarefas = new ArrayList<>();
        listaTarefas.add(new Tarefa("Abrir ventás para ventilar", "Aula 12"));
        listaTarefas.add(new Tarefa("Ordenar compoñentes e material", "Taller hardware"));
        listaTarefas.add(new Tarefa("Reparar o proxector", "Aula da bodega"));
        listaTarefas.add(new Tarefa("Coller xices", "Conserxería"));
        listaTarefas.add(new Tarefa("Arranxar goteira", "Recibidor"));
        listaTarefas.add(new Tarefa("Cambiar cable Ethernet", "Sala de profesores"));
        listaTarefas.add(new Tarefa("Desbloquear acceso a Internet", "Dpto. de Informática"));
        listaTarefas.add(new Tarefa("Poñer en marcha o ordenador", "Recibidor"));
        listaTarefas.add(new Tarefa("Arranxar un computador", "Taller hardware"));
        listaTarefas.add(new Tarefa("Actualizar software repetidor WiFi", "Sala de profesores"));
        listaTarefas.add(new Tarefa("Arranxar fotocopiadora", "Conserxería"));

        ArrayList<Xogador> xogadores = new ArrayList<>();
        Estudante e4 = new Estudante("@ddd", listaTarefas);
        Estudante e1 = new Estudante("@aaa", listaTarefas);
        Estudante e2 = new Estudante("@bbb", listaTarefas);
        Estudante e5 = new Estudante("@eee", listaTarefas);
        Estudante e3 = new Estudante("@ccc", listaTarefas);
        xogadores.add(e1);
        xogadores.add(e2);
        xogadores.add(e3);
        xogadores.add(e4);
        xogadores.add(e5);

        crearMenu(sc, xogadores, listaTarefas);

    }

    private static void crearMenu(Scanner sc, ArrayList<Xogador> xogadors, ArrayList<Tarefa> listaTarefas) {
        Menu MiMenu = new Menu("AmongSanCle", sc);
        Menu config = new Menu("Configuración", sc);

        MiMenu.addMenu(config);
        Menu tarefas = new Menu("Tarefas", sc);
        Menu xogadores = new Menu("Xogadores", sc);
        config.addMenu(tarefas);
        config.addMenu(xogadores);
        config.addMenu(new tResposta(sc));
        tarefas.addMenu(new EngadirTarefa(sc, listaTarefas));
        tarefas.addMenu(new BorrarTarefa(sc, listaTarefas));
        tarefas.addMenu(new VerTarefas(sc, listaTarefas));
        xogadores.addMenu(new EngadirXogador(sc, xogadors, listaTarefas));
        xogadores.addMenu(new BorrarXogador(sc, xogadors));
        xogadores.addMenu(new VerXogadores(sc, xogadors));

        ComponenteMenu xogar = new Xogar("Xogar", sc, xogadors, listaTarefas);
        MiMenu.addMenu(xogar);
        MiMenu.ejecutar();
    }
}
