package stack;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

import org.junit.Test;

public class StackTests {

	@Test
	public void newlyCreatedStackIsEmpty() {
		Stack s = new Stack();

		assertTrue(s.isEmpty());
	}

	@Test
	public void afterPushStackNoEmpty() {
		Stack s = new Stack();
		s.push(1);
		assertFalse(s.isEmpty());
	}

	@Test
	public void afterPushAndPopStackEmpty() {
		Stack s = new Stack();
		s.push(1);
		s.pop();
		assertTrue(s.isEmpty());
	}

	@Test
	public void emptyStackThrowsOnPop() {
		Stack s = new Stack();
		assertThrows(EmptyStackException.class, () -> s.pop());

	}

	@Test
	public void popReturnsWhatWasPushed() {
		Stack s = new Stack();
		s.push(67);
		assertEquals(67, s.pop());
	}

	@Test
	public void stackNotEmptyWhenLessPopThanPush() {
		Stack s = new Stack();
		s.push(67);
		s.push(6);
		s.pop();
		assertFalse(s.isEmpty());
	}

	@Test
	public void lastPopReturnsFirstPushValue() {
		Stack s = new Stack();
		s.push(67);
		s.push(6);
		s.pop();
		assertEquals(67, s.pop());
	}

	@Test
	public void stackOverflowExceptionWhenCapacityExceeded() {
		Stack s = new Stack();

		assertThrows(BufferOverflowException.class, () -> {
			for (int i = 0; i < s.capacity + 1; ++i)
				s.push(i);
		});
	}

	@Test
	public void afterClearStackIsEmpty() {
		Stack s = new Stack();
		s.push(67);
		s.push(6);
		s.clear();
		assertTrue(s.isEmpty());
	}

	@Test
	public void afterFourPushSizeEqualFour() {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		assertEquals(s.getSize(), 4);
	}
	
	@Test
	public void afterSetCapacityCapacityEqualTwo() {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.setCapacity(2);
		assertEquals(s.getSize(), 2);
	}
	
	@Test
	public void afterSetCapacityCapacityEqualFifteen() {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.setCapacity(15);
		assertEquals(s.getSize(), 15);
	}
	@Test
	public void afterSetCapacityCapacityEqualFour() {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(3);
		s.setCapacity(4);
		assertEquals(s.getSize(), 4);
	}
	
	@Test
	public void isFullCheck() {
		Stack s = new Stack();
		s.push(1);
	assertFalse(s.isFull());
	}
	
	@Test
	public void afterMakeStackFull() {
		Stack s = new Stack();
		s.makeStackFull();
		assertTrue(s.isFull());
		
	}
}
