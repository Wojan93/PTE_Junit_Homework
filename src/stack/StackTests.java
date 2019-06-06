package stack;

import static org.junit.Assert.*;

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
	public void afterPushStackIsNoLongerEmpty() {
		Stack s = new Stack();

		s.push(1);

		assertFalse(s.isEmpty());
	}

	@Test
	public void afterPushAndPopStackIsEmptyAgain() {
		Stack s = new Stack();

		s.push(1);
		s.pop();

		assertTrue(s.isEmpty());
	}

	@Test(expected = EmptyStackException.class)
	public void emptyStackThrowsOnPop() {
		Stack s = new Stack();

		s.pop();
	}

	@Test
	public void popReturnsWhatWasPushed() {
		Stack s = new Stack();

		s.push(1234);

		assertEquals(1234, s.pop());
	}

	@Test
	public void stackDoesNotBecomeEmptyWhenThereWasLessPopThanPush() {
		Stack s = new Stack();

		s.push(1);
		s.push(2);
		s.pop();

		assertFalse(s.isEmpty());
	}

	@Test
	public void lastPopReturnsFirstPushedValue() {
		Stack s = new Stack();

		s.push(1);
		s.push(2);
		s.pop();

		assertEquals(1, s.pop());
	}

	@Test(expected = BufferOverflowException.class)
	public void stackThrowsWhenTryingToPushMoreThanMaximumCapacity() {
		Stack s = new Stack();

		for (int i = 0; i < s.MAXIMUM_CAPACITY + 1; ++i)
			s.push(i);
	}
	
	// TODO configurable Stack capacity
	@Test
	public void stackHasConfigurableCapacity(){
		Stack s = new Stack(15);
		assertEquals(s.MAXIMUM_CAPACITY, 15);
	}
	// TODO Stack.clear()
	@Test
	public void stackClearMethod(){
		Stack s = new Stack();

		s.push(1);
		s.push(2);
		s.clear();
		assertTrue(s.isEmpty());
		
	}
	
	// TODO Stack.getSize()
	@Test
	public void stackGetSizeReturnsSize(){
		Stack s = new Stack();
		assertEquals(s.getSize(), 0);
		s.push(1);
		s.push(2);
		assertEquals(s.getSize(), 2);
	}
}
