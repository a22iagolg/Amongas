package Menu;
import java.util.Scanner;

public abstract class ComponenteMenu {
    protected ComponenteMenu padre;
    protected String nombre;
    Scanner sc;

    protected ComponenteMenu(String nombre, Scanner sc) {
        padre = null;
        this.nombre = nombre;
        this.sc = sc;
    }

    abstract void ejecutar();
}