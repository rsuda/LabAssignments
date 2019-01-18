package stack;

public interface Stack<E>
{
	//Check if the Stack is empty
	boolean isEmpty();
	
	//Return number of elements in the Stack
	int size();
	
	//Return the element at the top of the stack without removing it
	E peek();
	
	//Remove and return the top element of the Stack
	E pop();
	
	//Add the item to the top of the Stack, returning the item pushed
	E push(E item);
	
	//Determine the position of an item on the Stack
	//Returns the 1-based position, with the item on top being 1
	int search(Object o);
}
