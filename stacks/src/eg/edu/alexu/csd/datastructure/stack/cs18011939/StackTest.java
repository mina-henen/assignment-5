package eg.edu.alexu.csd.datastructure.stack.cs18011939;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {

	@Test
	void test() throws Exception {
		Stack test = new Stack();
		
		//////////* Testing size *//////////
		
		assertEquals(test.size(),0);
		
		//////////* Testing push *//////////
		
		test.push("m");
		test.push(9);
		test.push('a');
		
		assertEquals(test.size(),3);
		
		/////////* Testing peek *//////////
		
		Object o= test.peek();
		assertEquals(o,'a');
		assertEquals(test.size(),3);
		
		//////////* Testing pop *//////////
		
		Object oo= test.pop();
		Object ob= test.pop();
		
		assertEquals(oo,'a');
		assertEquals(ob,9);
		assertEquals(test.size(),1);
		
		/////////* Testing isEmpty */////////
		
		assertEquals(test.isEmpty(),false);
		test.pop();
		assertEquals(test.isEmpty(),true);

		
	}

}
