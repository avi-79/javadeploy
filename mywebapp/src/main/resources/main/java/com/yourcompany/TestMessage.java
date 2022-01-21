package com.sonata.ExceptionTest;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;
public class TestMessage {
String message="avinesh";
MessageException m=new MessageException(message);

@Test(expected= ArrayIndexOutOfBoundsException.class)

public void testprintMessage() {
	System.out.println("Inside the PrintMessage");
	m.printMessage();
}

@Ignore
@Test
public void testaddMessage() {
	System.out.println("Inside add Message");
	//message="hi"+message;
	assertEquals(message,m.addMessage());
	
}
}
