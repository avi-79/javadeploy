package TestSuitExample;

public class MessageClass {
	private String message;
	public MessageClass(String message) {
		
		this.message=message;
	}
	//print the message
	public String printMessage() {
		System.out.println(message);
		return message;
	}
	//add "HI!" to the message
	public String salutionMessage() {
		message ="HI!"+message;
		System.out.println(message);
		return message;
	}
}
