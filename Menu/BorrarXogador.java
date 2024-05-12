package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import src.Xogador;

public class BorrarXogador extends ComponenteMenu {
    ArrayList<Xogador> xogadores;

    public BorrarXogador(Scanner sc, ArrayList<Xogador> xogadores) {
        super("Borrar Xogador", sc);
        this.xogadores = xogadores;
    }

    void ejecutar() {
        int current = 1;
        System.out.println("----------- Lista de xogadores -----------");
        for (Xogador x : xogadores) {
            System.out.println(current + ". " + x.alias);
            current++;
        }
        System.out.print("Introduce el número del jugador a borrar: ");
        xogadores.remove(Integer.parseInt(sc.nextLine()) - 1);
        this.padre.ejecutar();
    }
}