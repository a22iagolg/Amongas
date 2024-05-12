package src;
import java.util.ArrayList;

public class Impostor extends Xogador {
    ArrayList<Xogador> eliminados = new ArrayList<>();

    Impostor(String alias, ArrayList<Tarefa> listaTarefas) {
        super(alias, listaTarefas);
    }

}
