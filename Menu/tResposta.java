package Menu;
import java.util.Scanner;

public class tResposta extends ComponenteMenu {
    public tResposta(Scanner sc) {
        super("Configurar tempo máximo de resposta", sc);
    }

    void ejecutar() {
        System.out.println("VER TAREFA ");
        this.padre.ejecutar();
    }
}