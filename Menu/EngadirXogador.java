package Menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import src.*;

public class EngadirXogador extends ComponenteMenu {
    ArrayList<Xogador> xogadores;
    ArrayList<Tarefa> listaTarefas;

    public EngadirXogador(Scanner sc, ArrayList<Xogador> xogadores, ArrayList<Tarefa> listaTarefas) {
        super("Engadir Xogador", sc);
        this.xogadores = xogadores;
        this.listaTarefas = listaTarefas;
    }

    void ejecutar() {
        String patron = "@[a-zA-Z0-9]{3}";
        System.out.print("Introduce o alias do xogador: ");
        String alias = sc.nextLine();
        Estudante newEstudante = new Estudante(alias, listaTarefas);
        if (!alias.matches(patron)) {
            System.out.println("Formato de alias no válido (Debe ser @xxx)");
            this.padre.ejecutar();
        } else {
            Iterator<Xogador> it = xogadores.iterator();
            while (it.hasNext()) {
                if (alias.equals(it.next().alias)) {
                    System.out.println("Alias ya en uso");
                    this.padre.ejecutar();
                }
            }
            xogadores.add(newEstudante);
            this.padre.ejecutar();
        }

    }
}