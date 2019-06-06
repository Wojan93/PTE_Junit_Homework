package stack;

import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

public class Stack {

	public int MAXIMUM_CAPACITY = 10;
	private int size = 0;
	private int[] contents = new int[MAXIMUM_CAPACITY];

	public Stack(){
		MAXIMUM_CAPACITY = 10;
	}
	
	public Stack(int maxCapacity){
		MAXIMUM_CAPACITY = maxCapacity;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void push(int i) {
		if (size == MAXIMUM_CAPACITY) {
			throw new BufferOverflowException();
		}
		contents[size++] = i;
	}

	public int pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return contents[--size];
	}
	
	public void clear(){
		size = 0;
	}
	
	public int getSize(){
		return size;
	}

}
