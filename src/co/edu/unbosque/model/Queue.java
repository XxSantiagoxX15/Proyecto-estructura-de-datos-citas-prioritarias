package co.edu.unbosque.model;

public class Queue {
	Node front;
	Node end;
	public void insertar (Task x) {
		Node New= new Node (x);
		if(Queuenull()) {
			front=New;
		}else {
			end.Next=New;
		}
		end=New;
		
	}
public  Queue rewind(Task x) {
		
		Node nuevo= new Node(x);
		nuevo.Next=front;
		front=nuevo;
		return this;
		
	}
	public Task eliminar () {
		Task aux = null;
		if(!Queuenull()) {
			aux=front.Object;
			front= front.Next;
		}
		
		return aux;	
	}

	public Task find (String tituloBuscado) {
	    Node current = front;

	    while (current != null) {
	        Task tarea = current.Object;
	        if (tarea.getTitle().equals(tituloBuscado)) {
	            return tarea; // Tarea encontrada
	        }
	        current = current.Next;
	    }

	    return null; // Tarea no encontrada
	}

	



	public Task frenteCola() {
		return front.Object;
		
		
	}
	public  boolean Queuenull() {
		return front==null;
		
	}
}
