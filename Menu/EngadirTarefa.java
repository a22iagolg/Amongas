package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import src.Tarefa;

public class EngadirTarefa extends ComponenteMenu {
    ArrayList<Tarefa> listaTarefas;

    public EngadirTarefa(Scanner sc, ArrayList<Tarefa> listaTarefas) {
        super("Engadir Tarefa", sc);
        this.listaTarefas = listaTarefas;
    }

    void ejecutar() {
        System.out.print("Introduce o nome da tarefa: ");
        String nome = sc.nextLine();
        System.out.print("Introduce a habitación onde se realizará: ");
        String habit = sc.nextLine();
        Tarefa t = new Tarefa(nome, habit);

        listaTarefas.add(t);

        this.padre.ejecutar();
    }
}