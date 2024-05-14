package Menu;

import java.util.Scanner;

import src.App;

public class tResposta extends ComponenteMenu {

    public tResposta(Scanner sc) {
        super("Configurar tempo máximo de resposta", sc);
    }

    void ejecutar() {
        System.err.println("Actual valor de espera: " + App.gettMax() / 1000 + " segundos.");
        System.out.print("Intoducir valor (en milisegundos) del tiempo máximo de espera: ");
        App.settMax(Long.parseLong(sc.nextLine()));
        System.out.println("Nuevo tiempo máximo: " + (App.gettMax() / 1000) + " segundos.");
        this.padre.ejecutar();
    }
}