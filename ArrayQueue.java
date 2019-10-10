public class ArrayQueue<T> implements Queue<T> {

	private int front, rear, size; 
	private T[] a; 

	public ArrayQueue() {
		this.front = 0;
		this.rear = 0;
		size = 0; 
		this.a = (T[]) new Object[10];
	}

	//checks to see if array is full by compairaing 
	//the number of objects and the array size
	public boolean isFull(){
		if (size == a.length){
			return true;
		}
		return false; 
	}

	//checks if its empty by checking the size 
	//(number of objects in array)
	public boolean empty(){
		return (this.size == 0);
	}

	// adds item to queue  
	// It changes rear and size 
	// circularly adds, thus not making array unnecissarily long on both ends
	public void enqueue(T item){
		if (isFull()){
			grow_array();
		}
		a[rear] = item;
		rear = (rear + 1) % a.length;
		size ++;
	}

	//first checks if empty and throws exception
	// decrements size, pops out the front item, then iterates size
	public T dequeue() throws Exception{
		if (empty()){
			throw new IllegalArgumentException(); 
		}
		T temp = a[front];
		front = (front + 1) % a.length; 
		size--; 
		return temp; 
	}



	//grows array in case that the front meets back
	//2 for loops to ensure correct order
	private void grow_array(){
		T[] new_array = (T[]) new Object[a.length * 2];
		for(int i = front; i < a.length; i ++){
			new_array[i - front] = a[i];
		}
		for(int i = 0; i < front; i ++){
			new_array[i + front + 1] = a[i];
		}
		a = new_array;
	}
}