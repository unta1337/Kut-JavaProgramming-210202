public class Greeting {
	private String name;
	private String greeting;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	public String sayHello() {
		return name + " " + greeting;
	}
}