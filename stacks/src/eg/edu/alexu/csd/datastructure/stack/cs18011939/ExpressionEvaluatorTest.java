package eg.edu.alexu.csd.datastructure.stack.cs18011939;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExpressionEvaluatorTest {

	@Test
	void test() throws Exception {
		ExpressionEvaluator test =new ExpressionEvaluator();
		
		////////////////////* Testing infixToPostfix() *////////////////
		
		String s1= test.infixToPostfix("100*2/5");
		assertEquals(s1,"100 2 * 5 /");
		String s2= test.infixToPostfix("5+(60-70)*9+303");
		assertEquals(s2,"5 60 70 - 9 * + 303 +");
		String s3= test.infixToPostfix("854 +90 / 88 3 +3");
		assertEquals(s3,"854 90 883 / + 3 +");
		String s4= test.infixToPostfix("50+3*");
		assertEquals(s4,"Invalid Expression");
		String s5= test.infixToPostfix("50+-3*6/20");
		assertEquals(s5,"50 0 3 - 6 * 20 / +");
		String s6= test.infixToPostfix("50+(3))");
		assertEquals(s6,"Invalid Expression");
		String s7= test.infixToPostfix("(70+(5*62)+22-(20+3)");
		assertEquals(s7,"Invalid Expression");
		String s8= test.infixToPostfix("[81+2-6/98*33)");
		assertEquals(s8,"Invalid Expression");
		String s9= test.infixToPostfix("[81+2-6/98*33)");
		assertEquals(s9,"Invalid Expression");
		String s10= test.infixToPostfix("d.8#$^");
		assertEquals(s10,"Invalid Expression");
		String s11= test.infixToPostfix("5-10*2");
		assertEquals(s11,"5 10 2 * -");
		String s12= test.infixToPostfix("(5-10)*2");
		assertEquals(s12,"5 10 - 2 *");
		String s13= test.infixToPostfix("-5*-6");
		assertEquals(s13,"0 5 - 0 6 - *");
		String s14= test.infixToPostfix("-93+30*(-6+2)");
		assertEquals(s14,"0 93 - 30  6 - 2 + * +");
		
		//////////////////////* Testing evaluate() *////////////////////
		
		int i1 = test.evaluate("5 2 / 1 2 / +");
		assertEquals(i1,3);
		int i2 = test.evaluate("25 4 * 2 / 2 / 2 /");
		assertEquals(i2,12);
		int i3 = test.evaluate("50 40 * 36 -");
		assertEquals(i3,1964);
		int i4 = test.evaluate("5 7 * 30 -");
		assertEquals(i4,5);
		int i5 = test.evaluate("9 10 -");
		assertEquals(i5,-1);
		int i6 = test.evaluate("0 99 -");
		assertEquals(i6,-99);
		int i7 = test.evaluate("5 10 - 2 *");
		assertEquals(i7,-10);
		int i8 = test.evaluate("5 10 2 * -");
		assertEquals(i8,-15);
		int i9 = test.evaluate("0 9 - 9 +");
		assertEquals(i9,0);
		int i10 = test.evaluate("0 12 - 2 * 0 3 - *");
		assertEquals(i10,72);
		int i11 = test.evaluate("0 9 - 3 * 0 9 - 0 3 - * +");
		assertEquals(i11,0);
		
		
	}

}
