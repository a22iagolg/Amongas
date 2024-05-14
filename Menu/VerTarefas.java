package Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import src.Tarefa;

public class VerTarefas extends ComponenteMenu {
    ArrayList<Tarefa> listaTarefas;

    public VerTarefas(Scanner sc, ArrayList<Tarefa> listaTarefas) {
        super("Ver Tarefas", sc);
        this.listaTarefas = listaTarefas;
    }

    void ejecutar() {
        Collections.sort(listaTarefas, new Tarefa());
        int current = 1;
        System.out.println("----------- Lista de tarefas -----------");
        for (Tarefa t : listaTarefas) {
            System.out.println(current + ". " + t.toString());
            current++;
        }
        System.out.println();
        System.out.println("Pulsa una tecla para volver al menú anterior");
        sc.nextLine();
        this.padre.ejecutar();

    }
}