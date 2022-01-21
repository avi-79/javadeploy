package TestSuitExample;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestClass2 {
	String message="Avinesh";
	MessageClass messageUtil=new MessageClass(message);
	@Test
	public void TestSalutionMessage() {
		System.out.println("Inside TestSalutionMessage()");
		message="HI"+"Avinesh";
		assertEquals(message,messageUtil.salutionMessage());
	}
	

}
