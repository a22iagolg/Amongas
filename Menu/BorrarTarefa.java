package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import src.Tarefa;

public class BorrarTarefa extends ComponenteMenu {
    ArrayList<Tarefa> listaTarefas;

    public BorrarTarefa(Scanner sc, ArrayList<Tarefa> listaTarefas) {
        super("Borrar Tarefas", sc);
        this.listaTarefas = listaTarefas;
    }

    void ejecutar() {
        int current = 1;
        System.out.println("----------- Lista de tarefas -----------");
        for (Tarefa t : listaTarefas) {
            System.out.println(current + ". " + t.toString());
            current++;
        }
        System.out.print("Introduce o número da tarefa a borrar: ");
        int index = Integer.parseInt(sc.nextLine()) - 1;
        if (index < listaTarefas.size())
            listaTarefas.remove(index);
        this.padre.ejecutar();
    }
}