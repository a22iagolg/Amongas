package src;

import java.util.Comparator;

public class Tarefa implements Comparator<Tarefa> {
    public String nome;
    public String habitacion;

    public Tarefa() {
    }

    public Tarefa(String n, String h) {
        this.nome = n;
        this.habitacion = h;
    }

    @Override
    public String toString() {
        return nome + " en " + habitacion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((habitacion == null) ? 0 : habitacion.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tarefa other = (Tarefa) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (habitacion == null) {
            if (other.habitacion != null)
                return false;
        } else if (!habitacion.equals(other.habitacion))
            return false;
        return true;
    }

    @Override
    public int compare(Tarefa t1, Tarefa t2) {
        // Primero comparar por habitación
        int comparacionHabitacion = t1.habitacion.compareTo(t2.habitacion);
        if (comparacionHabitacion != 0) {
            return comparacionHabitacion;
        }
        // Si las habitaciones son iguales, comparar por nombre
        return t1.nome.compareTo(t2.nome);
    }
}
