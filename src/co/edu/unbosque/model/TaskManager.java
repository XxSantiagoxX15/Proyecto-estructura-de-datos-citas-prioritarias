package co.edu.unbosque.model;

import java.util.Date;

public class TaskManager {
private  Queue arreglocolas[];
private Stack stack;
private List lista;

public TaskManager() {
	stack=new Stack();
	lista= new List();
        arreglocolas = new Queue[5];
        for (int i = 0; i < arreglocolas.length; i++) {
            arreglocolas[i] = new Queue();
        }
 
    }


public void insert(Task task) {
    Date currentDate = new Date(); 
    Date dueDate = task.getDueDate(); 

    long differenceInDays = (dueDate.getTime() - currentDate.getTime()) / (24 * 60 * 60 * 1000);

    
    int position = (int) differenceInDays;
    if (position >= 0 && position < arreglocolas.length) {
        arreglocolas[position].insertar(task);
        System.out.println(task.toString());
    } else {
    	
         lista.insert(task); 
        System.out.println( task.toString()+"Se agrego como no prioritaria");
    }
}


public void imprimirColas() {
    for (int i = 0; i < arreglocolas.length; i++) {
        System.out.println("Cola en posición " + i + ":");
        Queue cola = arreglocolas[i];
        Node current = cola.front; 
        
        while (current != null) {
            Task tarea = current.Object;
            System.out.println("  " + tarea.getTitle() + " - Fecha de vencimiento: " + tarea.getDueDate());
            current = current.Next; 
         
        }
 
    }

}
public void imprimirlista() {
	 lista.imprimirTareas();
} 
public void marcarnoprio(String x) {
	lista.checklist(x);
}
public void descarmarnoprio() {
	lista.rewind();
}
public void consultarnoprio(String x) {
	lista.consultar(x);
}


public Task obtenertarea() {
    Task tareaMayorPrioridad = null;

    if (!arreglocolas[0].Queuenull()) {
        tareaMayorPrioridad = arreglocolas[0].frenteCola(); 
        arreglocolas[0].eliminar(); 
        }else if(!arreglocolas[1].Queuenull()){
        	tareaMayorPrioridad = arreglocolas[1].frenteCola(); 
            arreglocolas[1].eliminar(); 
        }else if(!arreglocolas[2].Queuenull()){
        	tareaMayorPrioridad = arreglocolas[2].frenteCola(); 
            arreglocolas[2].eliminar(); 
        }else if(!arreglocolas[3].Queuenull()){
        	tareaMayorPrioridad = arreglocolas[3].frenteCola(); 
            arreglocolas[3].eliminar(); 
        }else if(!arreglocolas[4].Queuenull()){
        	tareaMayorPrioridad = arreglocolas[4].frenteCola(); 
            arreglocolas[4].eliminar(); 
        }else if(!arreglocolas[5].Queuenull()){
        	tareaMayorPrioridad = arreglocolas[5].frenteCola(); 
            arreglocolas[5].eliminar(); 
        }
    

    return tareaMayorPrioridad;
}

public Task Consultar(String tituloBuscado) {
    Task tareaEncontrada = null;

    for (int i = 0; i < arreglocolas.length; i++) {
        if (!arreglocolas[i].Queuenull()) {
            Task tarea = arreglocolas[i].find(tituloBuscado); // Utiliza tu método findTaskByTitle
            if (tarea != null) {
                tareaEncontrada = tarea;
                break; // Terminar el bucle una vez que se encuentra la tarea
            }
        }
    }

    System.out.println(tareaEncontrada);
    return tareaEncontrada;
}


public void check() {
	   Task tarea = obtenertarea(); 
	    stack.push(tarea);

	  
	    Task tareaEnPila = stack.peek(tarea);

	    if (tareaEnPila != null) {
	        System.out.println("La tarea está en la pila: " + tareaEnPila.toString());
	    } else {
	        System.out.println("La tarea no está en la pila.");
	    }
}





public void rewind() {
	try{
    Task tarea = stack.peek(null);
	
    if (tarea != null) {
        Date currentDate = new Date();
        Date dueDate = tarea.getDueDate();

        long differenceInDays = (dueDate.getTime() - currentDate.getTime()) / (24 * 60 * 60 * 1000);

        int position = (int) differenceInDays;

        // Verificar que la posición esté dentro del rango del arreglo arreglocolas
        if (position >= 0 && position < arreglocolas.length) {
            // Insertar la tarea en la cola de prioridad correspondiente
            arreglocolas[position].insertar(tarea);

            // Eliminar la tarea de la pila
            stack.pop();

            System.out.println("La tarea ha sido devuelta a la cola de prioridad " + position);
        } else {
            System.out.println("La fecha de vencimiento de la tarea está fuera de rango.");
        }
    } else {
        System.out.println("La pila está vacía, no hay tareas para devolver.");
    }
} catch (NullPointerException e) {
    System.out.println("La pila es nula ");
}
}

public Queue[] getArreglocolas() {
	return arreglocolas;
}


public void setArreglocolas(Queue[] arreglocolas) {
	this.arreglocolas = arreglocolas;
}
	
}

