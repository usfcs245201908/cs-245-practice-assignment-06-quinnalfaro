import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T>{

	private final int defaultSize = 10;
	private int top;
	private T[] a;

	//Intiallizes structure
	public ArrayStack() {
		this.a = (T[]) new Object[defaultSize];
		this.top = -1;
	}

	//if too small grows array else adds the item to the item to the iterated top
	public void push(T item){
		if(top == a.length - 1){
			grow_array();
		}
		a[++top] = item;
	}

	//Throws exception if empty else returns the top element decrementing top
	public T pop() throws Exception{
		if(empty()){
			throw new EmptyStackException();
		}
		return(a[top --]);
	}

	//if empty throws exception, else it returns the top element while keeping it in the array still
	public T peek() throws Exception{
		if(top == a.length - 1){
			throw new EmptyStackException();
		}
		return a[top];
	}

	//Checks if the stack is empty
	public boolean empty(){
		return top == -1;
	}



	//grows the array to twice its size by making a new array of twice the size and then putting all the data
	//into the new array 
	private void grow_array(){
		T[] new_array = (T[]) new Object[a.length * 2];
		for(int i = 0; i < top; i ++){
			new_array[i] = a[i];
		}
		a = new_array;

	}
	
}