package Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import src.*;

public class Xogar extends ComponenteMenu {
    ArrayList<Xogador> xogadores;
    ArrayList<Tarefa> listaTarefas;

    public Xogar(String nombre, Scanner sc, ArrayList<Xogador> xogadores, ArrayList<Tarefa> listaTarefas) {
        super(nombre, sc);
        this.xogadores = xogadores;
        this.listaTarefas = listaTarefas;
    }

    @Override
    void ejecutar() {
        boolean gameOver = false;

        // Crear impostor y ordenar lista jugadores para que no cante y aprovechar index
        Random random = new Random();
        int indexAsesino = random.nextInt(0, xogadores.size());
        Impostor impostor = new Impostor(xogadores.get(indexAsesino));
        xogadores.remove(indexAsesino);
        xogadores.add(impostor);
        // System.out.println("IMPOSTOR ES: " + impostor.alias);
        Collections.sort(xogadores);

        // Reiniciar tareas por si se añadió/eliminó alguna en el menú
        for (Xogador x : xogadores) {
            x.addTarefa(listaTarefas);
        }

        // bucle principal, por rondas, si se llega a 5 (num max de tareas) se acabaría
        int rolda = 0;
        while (gameOver == false) {
            HashMap<Xogador, Tarefa> posiciones = new HashMap<>();
            System.out.println();
            System.out.println("###############");
            System.out.println("Rolda nº " + rolda);
            System.out.println("###############");
            System.out.println();
            System.out.println("Os xogadores nesta rolda acaban de facer: ");
            System.out.println();

            for (Xogador x : xogadores) {
                if (x.vivo && !x.expulsado) {
                    Tarefa t = x.tarefas.poll();
                    posiciones.put(x, t);
                    System.out.println(x.alias + " hizo: " + t);
                }
            }

            Set<Xogador> keyList = posiciones.keySet();
            for (Xogador key : keyList) {
                if (key.getClass().getName().equals("src.Impostor")) {
                    Impostor asesino = (Impostor) key;
                    String habitaAse = posiciones.get(key).habitacion;
                    for (Xogador key2 : keyList) {
                        if (!key2.getClass().getName().equals("src.Impostor")
                                && posiciones.get(key2).habitacion.equals(habitaAse)) {
                            asesino.asesinar(key2);
                            if (key2.vivo == false) {
                                System.out.println();
                                System.out
                                        .println("\u001B[31m" + key2.alias + " foi asesinado mentres facía: "
                                                + posiciones.get(key2) + "\u001B[0m");
                                gameOver = comprobarFinal();
                            }
                        }
                    }
                }
            }

            if (gameOver) {
                System.out.println();
                System.out.println("\u001B[31mEL IMPOSTOR GANA\u001B[0m");
                imprimirResultado();
                break;
            }

            long tMax = App.gettMax();
            System.out.println();
            System.out.println("¿Expulsar a alguien? Tiempo para escribir: " + tMax / 1000 + " segundos.");
            long start = System.currentTimeMillis();
            String expulsado = sc.nextLine();
            long end = System.currentTimeMillis();
            long tReal = end - start;

            Iterator<Xogador> it = xogadores.iterator();
            if (tReal < tMax) {
                while (it.hasNext() && !gameOver) {
                    Xogador x = it.next();
                    if (x.alias.equals(expulsado)) {
                        x.expulsado = true;
                        x.vivo = false;
                        System.out.println();
                        System.out.println("HAS EXPULSAO A " + x.alias);
                        if (x.getClass().getSimpleName().equals("Impostor")) {
                            gameOver = true;
                            System.out.println("\u001B[92m" + x.alias + " ERA UN IMPOSTOR");
                            System.out.println("HAS GANADO, ENHORABUENA\u001B[0m");
                            imprimirResultado();
                            break;
                        } else {
                            System.out.println("\u001B[31m" + x.alias + " NO ERA UN IMPOSTOR" + "\u001B[0m");
                            gameOver = comprobarFinal();
                            if (gameOver == true) {
                                System.out.println();
                                System.out.println("\u001B[31mEL IMPOSTOR GANA\u001B[0m");
                                imprimirResultado();
                                break;
                            }
                        }
                    }
                }
            } else {
                System.out.println("Tiempo de espera superado");
            }
            rolda++;

            if (!gameOver && rolda == 5) {
                System.out.println("\u001B[92mSE HAN ACABADO LAS TAREAS, LOS TRIPULANTES GANAN!!!\u001B[0m");
                gameOver = true;
                imprimirResultado();
            }
        }
        this.padre.ejecutar();
    }

    boolean comprobarFinal() {
        int eliminados = 0;
        for (Xogador x : xogadores) {
            if (x.expulsado || !x.vivo) {
                eliminados++;
            }
        }
        if (eliminados == xogadores.size() - 2) {
            return true;
        }
        return false;
    }

    private void imprimirResultado() {
        // ordenar por roles/tipos de muerte
        String alias = "";
        Collections.sort(xogadores, new ComparatorXog());
        System.out.println();
        System.out.println("Comprobar impostores y estado de jugadores: ");
        Iterator<Xogador> it = xogadores.iterator();
        while (it.hasNext()) {
            Xogador x = it.next();
            if (x.vivo == true && !x.expulsado) {
                String clase = "";
                if (x.getClass().getSimpleName().equals("Impostor")) {
                    clase = "\u001B[31mImpostor\u001B[92m";
                } else
                    clase = "Estudante";
                System.out.println("\u001B[92m" + x.alias + " era un " + clase
                        + " y acabó el juego vivo!\u001B[0m");
            } else if (x.vivo == false && !x.expulsado)
                System.out.println("\u001B[31m" + x.alias + " era un " + x.getClass().getSimpleName()
                        + " y acabó el juego muerto por asesinato\u001B[0m");

            else
                System.out.println("\u001B[31m" + x.alias + " era un " + x.getClass().getSimpleName()
                        + " y acabó el juego muerto por expulsión\u001B[0m");

            x.restaurar();
            if (x.getClass().getSimpleName().equals("Impostor")) {
                alias = x.alias;
                it.remove();
            }
        }
        xogadores.add(new Estudante(alias, listaTarefas));
    }

}
