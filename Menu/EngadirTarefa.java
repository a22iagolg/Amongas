package Menu;
import java.util.Scanner;


public class EngadirTarefa extends ComponenteMenu {
    public EngadirTarefa(Scanner sc) {
        super("Engadir Tarefa", sc);
    }

    void ejecutar() {
        System.out.println("ENGAIR TAREFA ");
        this.padre.ejecutar();
    }
}