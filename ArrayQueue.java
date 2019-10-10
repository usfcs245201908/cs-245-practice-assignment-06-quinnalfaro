public class ArrayQueue<T> implements Queue {

	private int front, rear, size, arraySize; 
	private T[] a; 

	public ArrayQueue() {
		arraySize = 10;
		front = rear = size = 0; 
		T[] a = (T[]) new Object[arraySize];
	}

	//checks to see if array is full by compairaing 
	//the number of objects and the array size
	public boolean isFull(){
		return (size == arraySize); 
	}

	//checks if its empty by checking the size 
	//(number of objects in array)
	public boolean empty(){
		return (size == 0);
	}

	// adds item to queue  
	// It changes rear and size 
	// circularly adds, thus not making array unnecissarily long on both ends
	public void enqueue(T item){
		if (isFull()){
			grow_array(); 
		}
		rear = (rear + 1) % arraySize;
		a[rear] = item;
		size ++;
	}

	//first checks if empty and throws exception
	// decrements size, pops out the front item, then iterates size
	public T dequeue() throws Exception{
		if (empty()){
			throw new IllegalArgumentException(); 
		}
		size--; 
		T temp = a[front]; 
		front = (front + 1) % arraySize; 
		return temp; 
	}



	//grows array in case that the front meets back
	//2 for loops to ensure correct order
	private void grow_array(){
		T[] new_array = (T[]) new Object[a.length * 2];
		for(int i = 0; i < arraySize - front; i ++){
			new_array[i] = a[front + i];
		}
		for(int i = 0; i < front; i ++){
			new_array[i + arraySize - front] = a[xi];
		}
		a = new_array;

	}
}