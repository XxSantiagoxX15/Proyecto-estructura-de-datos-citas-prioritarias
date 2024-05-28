package co.edu.unbosque.model;

public class Node {
	 public Task Object;
	   public Node Next;

	   public Node(Task Object) {
	      this.Object = Object;
	   }

	   public Node(Node Next, Task Object) {
	      this.Next = Next;
	      this.Object = Object;
	   }
}
