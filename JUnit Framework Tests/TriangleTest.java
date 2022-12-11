import static org.junit.Assert.*;
import org.junit.Test;

public class TriangleTest {

	@Test
	public void test1(){
		Triangle triangle = new Triangle("12","12","12");
		assertEquals("This is an equilateral triangle. ",triangle.triangleType());	
	}//end test
	
	@Test
	public void test2(){
		Triangle triangle = new Triangle("3","3","5");
		assertEquals("This is an isosceles triangle. ",triangle.triangleType());
	 	
	}//end test
	
	@Test
	public void test3(){
		Triangle triangle = new Triangle("4","5","6");
		assertEquals("This is a scalene triangle. ", triangle.triangleType());
		// expected value: "This is a scalene triangle. "  
		// value returned from the method: triangle.triangleType() 
	}//end test
	
	@Test
	public void test4(){

        		Triangle triangle = new Triangle("5","7","9");
		assertEquals("This is a scalene triangle. ", triangle.triangleType());
		// change above arguments(true, true) to (expectedValue, valueReturned)

	}//end test

	@Test
	public void test5(){
		Triangle triangle = new Triangle("1","3","6");
		assertEquals("Not a valid triangle!\n", triangle.triangleType());
	}//end test
	
	@Test
	public void test6(){
	Triangle triangle = new Triangle("9","9","3");
		assertEquals("This is an isosceles triangle. ", triangle.triangleType());
	}//end test
	
	@Test
	public void test7(){
	Triangle triangle = new Triangle("1","1","1");
		assertEquals("This is an equilateral triangle. ", triangle.triangleType());
	}//end test
	
	@Test
	public void test8(){
	Triangle triangle = new Triangle("2","3","4");
		assertEquals("This is a scalene triangle. ", triangle.triangleType());
	}//end test
	
	@Test
	public void test9(){
		Triangle triangle = new Triangle("9","9","2");
		assertEquals("This is an isosceles triangle. ", triangle.triangleType());
	}//end test
	
	@Test
	public void test10(){
		Triangle triangle = new Triangle("6","7","7");
		assertEquals("This is an isosceles triangle. ", triangle.triangleType());
	}//end test	
	
	@Test
	public void test11(){
		Triangle triangle = new Triangle("1","1","8");
		assertEquals("Not a valid triangle!\n", triangle.triangleType());
	}//end test
	
	@Test
	public void test12(){
		Triangle triangle = new Triangle("1","3","9");
		assertEquals("Not a valid triangle!\n", triangle.triangleType());
	}//end test
	
	@Test
	public void test13(){
        Triangle triangle = new Triangle("623","398","337");
		assertEquals("This triangle is too big.\n", triangle.triangleType());	
	}//end test
	
	@Test
	public void test14(){
		Triangle triangle = new Triangle("3","-3","3");
		assertEquals("At least one side is negative!\nNot a valid triangle!\n", triangle.triangleType());
	}//end test
	
	@Test
	public void test15(){
		Triangle triangle = new Triangle("7","5","7");
		assertEquals("This is an isosceles triangle. ", triangle.triangleType());
	}//end test
	
	@Test
	public void test16(){
		Triangle triangle = new Triangle("4","2","[]");
		assertEquals("The side 3 is not an integer number.\n\nNot a valid triangle!\n", triangle.triangleType());
	}//end test	
	
	@Test
	public void test17(){
		Triangle triangle = new Triangle("1","1","1");
		assertEquals("This is an equilateral triangle. ", triangle.triangleType());
	}//end test
	
	
	@Test
	public void test18(){
		Triangle triangle = new Triangle("0","3","0");
		assertEquals("Not a valid triangle!\n", triangle.triangleType());
	}//end test	
	
	
	@Test
	public void test19(){
		Triangle triangle = new Triangle("7","8","0");
		assertEquals("Not a valid triangle!\n", triangle.triangleType());	
	}//end test
	
	@Test
	public void test20(){
		Triangle triangle = new Triangle("e","9","9");
		assertEquals("The side 1 is not an integer number.\n\nNot a valid triangle!\n", triangle.triangleType());	
	}//end test

}