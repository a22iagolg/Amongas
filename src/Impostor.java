package src;

import java.util.ArrayList;
import java.util.Random;

public class Impostor extends Xogador {
    ArrayList<Xogador> eliminados = new ArrayList<>();

    public Impostor(String alias, ArrayList<Tarefa> listaTarefas) {
        super(alias, listaTarefas);
    }

    public Impostor(Xogador e) {
        super(e.alias, e.listaTarefas);
    }

    public void asesinar(Xogador x) {
        Random random = new Random();
        // 0 es que si || 1 es que no
        int conseguido = random.nextInt(2);
        if (conseguido == 0) {
            x.vivo = false;
            eliminados.add(x);
        }
    }
}
