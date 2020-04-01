package eg.edu.alexu.csd.datastructure.stack.cs18011939;

public class Stack implements IStack {
	public class Node {
		private Object data; 
	    private Node next; 
	    public Node(){}
	    public Node(Object data) { this.data = data; }
	    public Node(Object data, Node next) {this.data= data; this.next= next;}
	    /** Returns the element of this node. */

		public Object getObj() { return data; }

		/** Returns the next node of this node. */

		public Node getNext() { return next;  }


		/** Sets the element of this node. */

		public void setObj(Object data) {this.data = data;}

		/** Sets the next node of this node.*/

		public void setNext(Node next) {this.next = next;}

	}
	private Node top =null;
	private int size= 0;
	public Stack() {}

	@Override
	public Object pop(){
		// TODO Auto-generated method stub
		if(isEmpty()){throw new IllegalStateException("Stack is Empty.");}
		Object temp= top.getObj();
		top= top.getNext();
		size--;
		return temp;
	}

	@Override
	public Object peek(){
		// TODO Auto-generated method stub
		if(isEmpty()){throw new IllegalStateException("Stack is Empty.");}
		else
			{
			return top.getObj();
			}
	}

	@Override
	public void push(Object element) {
		// TODO Auto-generated method stub
		Node newtop= new Node(element,top);
		top= newtop;
		size++;

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size==0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
