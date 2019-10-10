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
			return; 
		}
		rear = (rear + 1) % arraySize;
		a[rear] = item;
		size ++;
	}

	//first checks if empty and throws exception if so
	public T dequeue() throws Exception{
		if (empty()){
			throw new IllegalArgumentException(); 
		}
		size--; 
		T temp = a[front]; 
		front = (front + 1) % arraySize; 
        return temp; 
    }
}