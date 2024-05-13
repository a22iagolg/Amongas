package Menu;

import java.util.Scanner;

public class tResposta extends ComponenteMenu {
    long tMax;

    public tResposta(Scanner sc, long tMax) {
        super("Configurar tempo máximo de resposta", sc);
        this.tMax = tMax;
    }

    void ejecutar() {
        System.err.println("Actual valor de espera: " + tMax / 1000 + " segundos.");
        System.out.print("Intoducir valor (en milisegundos) del tiempo máximo de espera: ");
        tMax = Long.parseLong(sc.nextLine());
        System.out.println("Nuevo tiempo máximo: " + (tMax / 1000) + " segundos.");
        this.padre.ejecutar();
    }
}