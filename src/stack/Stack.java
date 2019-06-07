package stack;

import java.nio.BufferOverflowException;
import java.util.Arrays;

import java.util.EmptyStackException;

public class Stack {

	public int capacity = 4;
	private int size = 0;
	private int[] contents = new int[capacity];

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(int i) {

		if (size == capacity) {
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

	public int getSize() {
		return size;
	}

	public void clear() {
		for (int i = 0; i < capacity; i++) {
			contents[i] = 0;
		}
		size = 0;
	}

	public boolean isFull() {
		if (size == contents.length) {
			return true;
		} else
			return false;
	}

	public void makeStackFull() {
		for (int i = 0; i < contents.length; i++) {
			push(i + 1);
		}
	}

	public void setCapacity(int newCapacity) {
		if (newCapacity < this.capacity) {
			System.out.println("Za ma³a pojemnoœæ, czêœæ danych zostanie usuniêta");
			size = newCapacity;
		} else if (newCapacity > this.capacity) {
			size = newCapacity;
		} else if (this.capacity == newCapacity) {
		
		}
	}

}
