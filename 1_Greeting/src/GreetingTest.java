public class GreetingTest {
	public static void main(String[] args) {
		Greeting greeting = new Greeting();
		greeting.setName("홍길동");
		greeting.setGreeting("안녕!");
		System.out.println(greeting.sayHello());
	}
}