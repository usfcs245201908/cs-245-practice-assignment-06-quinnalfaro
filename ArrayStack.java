import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T>{

	private final int defaultSize = 10;
	private int top;
	private T[] a;

	public ArrayStack() {
		this.a = (T[]) new Object[defaultSize];
		this.top = -1;
	}

	public void push(T item){
		if(top == a.length - 1){
			grow_array();
		}
		a[++top] = item;
	}

	public T pop() throws Exception{
		if(empty()){
			throw new EmptyStackException();
		}
		return(a[top --]);
	}

	public T peek() throws Exception{
		if(top == a.length -1){
			throw new EmptyStackException();
		}
		return a[top];
	}

	public boolean empty(){
		if (top == -1){
			return true;
		}
		return false;
	}




	private void grow_array(){
		T[] new_array = (T[]) new Object[a.length * 2];
		for(int i = 0; i < a.length; i ++){
			new_array[i] = a[i];
		}
		a = new_array;

	}
	
}