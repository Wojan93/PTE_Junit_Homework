package inheritance;
import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// praca domowa
public class ManagerJTest {
	Manager mng1;
	Employee ee1;
	
	@Before
	public void setUp() throws Exception {
		mng1 = new Manager("Manager1", 35, 2015, 12, 11);
		ee1 = new Employee("Employee1", 15, 2012, 2, 15);
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetSalary(){
		
		assertTrue(mng1.getSalary() == 35 );
		assertTrue(ee1.getSalary() == 15 );		
	}
	
	@Test
	public void testSetBonus(){
		mng1.setBonus(10);
		assertTrue(mng1.getSalary() == 45 );
	}
	
	@Test
	public void testGetName()
	{
		assertTrue(mng1.getName() == "Manager1");
		assertTrue(ee1.getName() == "Employee1");
	}
	
	@Test
	public void testGetHireDate()
	{
		assertTrue(mng1.getHireDay().equals( new GregorianCalendar(2015, 11, 11).getTime()));
		assertTrue(ee1.getHireDay().equals( new GregorianCalendar(2012, 1, 15).getTime()));
	}
	
	
	@Test
	public void testRiseSalary(){
		assertTrue(mng1.getSalary() == 35 );
		mng1.raiseSalary(100);
		assertTrue(mng1.getSalary() == 70.0);
		
		assertTrue(ee1.getSalary() == 15 );
		ee1.raiseSalary(10);
		assertTrue(ee1.getSalary() == 16.5);
		ee1.raiseSalary(0);
		assertTrue(ee1.getSalary() == 16.5);
		
		mng1.raiseSalary(-50);
		assertTrue(mng1.getSalary() == 35 );
		
		
	}
	
}
