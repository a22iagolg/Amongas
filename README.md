# Impresións ao escribir a App. ¿tiveches nalgún momento a sensación que algunha parte do código a estabas escribindo de forma non apropiada por falta de non aplicar un patrón non visto ou por calquera outra cuestión?.
Me dio la sensación de que al aplicar el patrón Composite para el menú, siguiendo la guía hecha en los apuntes, al crear un menú hoja me forzaba a crear una nueva clase para que hiciese el ejecutar() que yo quería, es decir: Para borrar un personaje y una tarea las operaciones son similares pero como manejan listas distintas y tienen que pedir entradas distintas me vi forzado a crear dos clases diferentes. Lo mismo para el resto de paralelismos entre las configuraciones de Xogador/Tarefa.  
# Indica si precisañes empregar iteradores donde e porqué.
Si, repetidas veces. A la hora de recorrer Arrays tanto de Xogador como de Tarefa, ya que si intentaba modificarlo con el for mejorado me daba en muchos casos el error de concurrencia. Por ejemplo a la hora de restaurar el impostor en estudiante, tenía que remover de la lista al impostor y luego añadir un nuevo Estudante, sin el iterator me daría error.

# Indica si precisañes sobreescribir hashcode/equals donde e porqué.
Sí, en la clase Tarefa, para evitar que se creasen tarefas con los mismos datos. 
# Indica donde usaches comparable/comparator e porqué.
Para Tarefa utilicé directamente comparator y un constructor vacío, lo que me permite pasar la propia clase como Comparator, en este compare ordeno por habitacion y si son iguales, por nombre de tarea.
Para Xogador implementé Comparable en su clase, con el método compareTo() que compara los alias directamente para ordenarlos alfabéticamente (para las rondas sobretodo). Sin embargo para el final de la partida quise imprimirlo como en el vídeo, ordenado por tipo de Xogador y por su estado, para lo que creé la clase ComparatorXog, que se encarga de ello.

# Unha lista breve das meioras achegadas por ti, e dicir, de funcións e restriccións que non se piden no enunciado.
Aunque tenía algunas ideas, preferí acabar rápido por falta de tiempo, con lo que no he implementado nada muy distinto a lo visto en el vídeo. 
Añado colores para que se vea un poco más claro qué está pasando en la consola del Visual y los asesinatos tienen lugar al FINAL de la ronda, para que se parezca un poco más al juego original, donde al juntarnos en la mesa veías quien había muerto.

# Outras observacións.
El código que he hecho no me gusta, no he tenido tiempo de mejorarlo y doy por supuesto que he metido la gamba en muchos sitios pero funciona. O eso parece. 