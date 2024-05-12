package Menu;
import java.util.Scanner;


public class BorrarTarefa extends ComponenteMenu {
    public BorrarTarefa(Scanner sc) {
        super("Borrar Tarefa", sc);
    }

    void ejecutar() {
        System.out.println("BORRAR TAREFA ");
        this.padre.ejecutar();
    }
}