package src;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Xogador {
    public String alias;
    Queue<Tarefa> tarefas = new LinkedList<>();

    Xogador(String alias, ArrayList<Tarefa> list) {
        this.alias = alias;
        this.addTarefa(list);
    }

    void addTarefa(ArrayList<Tarefa> listaTarefas) {
        ArrayList<Tarefa> listaCopy = new ArrayList<>(listaTarefas);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(listaCopy.size());
            Tarefa t = listaCopy.get(index);
            this.tarefas.add(t);
            listaCopy.remove(t);
        }
    }
}
