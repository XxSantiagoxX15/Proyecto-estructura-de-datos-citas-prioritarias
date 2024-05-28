package co.edu.unbosque.model;

public class Stack {
	Node cabeza;
	public Stack() {
		
		cabeza=null;
	
	}

	
	public  Stack push(Task x) {
		
		Node nuevo= new Node(x);
		nuevo.Next=cabeza;
		cabeza=nuevo;
		return this;
		
	}
	

	
	public Task peek(Task x){
		return cabeza.Object;
	}
	

		
	public Node pop() {
	    if (this.cabeza == null) {
	        
	        return null; 
	    }
	    
	    Node pop = this.cabeza;
	    this.cabeza = this.cabeza.Next;
	    return pop;
	}
	
}
