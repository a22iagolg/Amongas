package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Xogador implements Comparable<Xogador> {
    public String alias;
    ArrayList<Tarefa> listaTarefas;
    public boolean expulsado = false;
    public boolean vivo = true;
    public Queue<Tarefa> tarefas = new LinkedList<>();

    Xogador(String alias, ArrayList<Tarefa> list) {
        this.alias = alias;
        this.listaTarefas = list;
    }

    public void addTarefa(ArrayList<Tarefa> listaTarefas) {
        tarefas.clear();
        ArrayList<Tarefa> listaCopy = new ArrayList<>(listaTarefas);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(listaCopy.size());
            Tarefa t = listaCopy.get(index);
            this.tarefas.add(t);
            listaCopy.remove(t);
        }
    }

    @Override
    public int compareTo(Xogador o) {
        return this.alias.compareTo(o.alias);
    }
}