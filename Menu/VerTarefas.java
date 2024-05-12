package Menu;
import java.util.Scanner;


public class VerTarefas extends ComponenteMenu {
    public VerTarefas(Scanner sc) {
        super("Ver Tarefas", sc);
    }

    void ejecutar() {
        System.out.println("VER TAREFA ");
        this.padre.ejecutar();
    }
}