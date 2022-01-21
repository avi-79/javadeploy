package TestSuitExample;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Testclass {
	String message="Avinesh";
	String message1="chinnu";
	MessageClass messageUtil=new MessageClass(message);
	@Test
	public void PrintMessage() {
		System.out.println("inside TestpPrintMessage()");
		assertEquals(message1,messageUtil.printMessage());
	}
}
