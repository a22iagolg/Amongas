package src;

import java.util.Comparator;

public class ComparatorXog implements Comparator<Xogador> {

    @Override
    public int compare(Xogador o1, Xogador o2) {
        if (o1.getClass().getSimpleName().equals("Estudante") && (o2.getClass().getSimpleName().equals("Impostor")))
            return -1;
        else if (o1.getClass().getSimpleName().equals("Estudante")
                && (o2.getClass().getSimpleName().equals("Estudante"))) {
            if (o1.vivo && !o2.vivo)
                return -1;
            else if (!o1.vivo && o2.vivo)
                return 1;
            else if (o1.vivo && o2.vivo) {
                return o1.alias.compareTo(o2.alias);
            } else {
                // los dos tan muertos
                if (!o1.expulsado && o2.expulsado)
                    return -1;
                else if (o1.expulsado && !o2.expulsado)
                    return 1;
                else
                    return o1.alias.compareTo(o2.alias);
            }

        } else
            return 0;
    }
}