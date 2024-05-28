package co.edu.unbosque.model;

public class List {
	 Node cabeza;
	    int cantElementos;
	    private Stack stack;

	    public List(){
	    	stack= new Stack();
	    	
	        cabeza=null;
	        cantElementos=0;
	    }
	    
	    
	    public List insert(Task x){
	        Node nuevo= new Node(x);
	        nuevo.Next=cabeza;
	        cabeza=nuevo;
	        return this;
	    }
	    public void imprimirTareas() {
	        Node current = cabeza;
	        System.out.println("Tareas en la lista:");
	        while (current != null) {
	            Task tarea = current.Object;
	            System.out.println("  " + tarea.getTitle() + " - Fecha de vencimiento: " + tarea.getDueDate());
	            current = current.Next;
	        }
	    }
	    public void checklist(String taskName) {
	        Node previous = null;
	        Node current = cabeza;

	        while (current != null) {
	            Task tarea = current.Object;

	            // Verifica si el nombre de la tarea coincide con el proporcionado
	            if (tarea.getTitle().equals(taskName)) {
	                // Crea un nuevo nodo para la pila y agrega la tarea
	                Node nuevo = new Node(tarea);
	                nuevo.Next = stack.cabeza;
	                stack.cabeza = nuevo;

	                // Elimina la tarea de la lista
	                if (previous == null) {
	                    // La tarea a eliminar es la primera en la lista
	                    cabeza = cabeza.Next;
	                } else {
	                    // La tarea a eliminar está en el medio o al final de la lista
	                    previous.Next = current.Next;
	                }

	                System.out.println("Tarea '" + taskName + "' marcada como realizada y movida a la pila.");
	                return; // Termina el método después de encontrar y procesar la tarea
	            }

	            // Avanza al siguiente nodo
	            previous = current;
	            current = current.Next;
	        }

	        // Si llegamos aquí, significa que no se encontró la tarea
	        System.out.println("La tarea '" + taskName + "' no se encontró en la lista.");
	    }
	    public void consultar(String name) {
	        Node current = cabeza;
	        boolean found = false; 
	        while (current != null) {
	            Task tarea = current.Object;
	            if (tarea.getTitle().equals(name)) {
	                System.out.println(tarea.toString());
	                found = true; 
	                break; 
	            }
	            current = current.Next; 
	        }
	        
	        if (!found) {
	            System.out.println("No se encontró tarea");
	        }
	    }
	    
	    public void rewind() {
	    	try {
	        Task tarea = stack.peek(null); // Obtén la tarea en la parte superior de la pila sin eliminarla

	        if (tarea != null) {
	            // Inserta la tarea de nuevo en tu lista
	            Node nuevo = new Node(tarea);
	            nuevo.Next = cabeza;
	            cabeza = nuevo;

	            // Elimina la tarea de la pila
	            stack.pop();

	            System.out.println("La tarea ha sido restaurada en la lista.");
	        } else {
	            System.out.println("La pila está vacía, no hay tareas para restaurar.");
	        }
	    }catch (NullPointerException e) {
	    	System.out.println("pila vacia");
	    }
	    }
}
