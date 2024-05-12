package Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu extends ComponenteMenu {
    List<ComponenteMenu> hijos = new ArrayList<>();

    public Menu(String nombre, Scanner sc) {
        super(nombre, sc);
    }

    public void addMenu(ComponenteMenu cm) {
        this.hijos.add(cm);
        cm.padre = this;
    }

    @Override

    public void ejecutar() {
        int numMenu = -1;
        while (numMenu == -1) {
            System.out.println();
            System.out.println("Menú " + this.nombre);
            System.out.println("--------------------");
            for (int i = 0; i < hijos.size(); i++) {
                System.out.println(i + ". " + hijos.get(i).nombre);
            }
            System.out.println(hijos.size() + ". Salir");
            System.out.print("Teclea número opción: ");
            String opcion = sc.nextLine();
            if (opcion.matches("\\d+")) {
                int numOpcion = Integer.parseInt(opcion);
                if (numOpcion >= 0 && numOpcion <= hijos.size()) {
                    numMenu = numOpcion;
                }
            }
        }
        if (numMenu == this.hijos.size()) {// si el usuario elige salir
            if (this.padre == null) {// si el padre es null, es el menú principal y salimos de la aplicación
                System.out.println("CERRANDO APP");
                System.exit(0);
            } else {
                this.padre.ejecutar();
            }
        } else {
            this.hijos.get(numMenu).ejecutar();
        }
    }
}