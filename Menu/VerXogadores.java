package Menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import src.Xogador;

public class VerXogadores extends ComponenteMenu {
    ArrayList<Xogador> xogadores;

    public VerXogadores(Scanner sc, ArrayList<Xogador> xogadores) {
        super("Ver Xogadores", sc);
        this.xogadores = xogadores;
    }

    void ejecutar() {
        Collections.sort(xogadores);
        int current = 1;
        System.out.println("----------- Lista de xogadores -----------");
        for (Xogador x : xogadores) {
            System.out.println(current + ". " + x.alias);
            current++;
        }
        System.out.println();
        System.out.println("Pulsa una tecla para volver al menú anterior");
        sc.nextLine();
        this.padre.ejecutar();

    }
}