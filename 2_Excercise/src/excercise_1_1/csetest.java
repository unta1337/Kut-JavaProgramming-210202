package excercise_1_1;

// 하나의 자바 소스 파일에는 하나의 public class만 존재할 수 있다.
class CSE {
	private String title;
	
	public void setTitle(String title) {
		// 기존의 _title을 이용한 변수 구분도 사용할 수 있으나, this 포인터를 이용해 인수와 인스턴스 변수를 구분할 수 있다.
		this.title = title;
	}
	
	// 함수의 반환 타입을 명시해야 한다.
	public String getTitle() {
		return title;
	}
}

// 주 클래스는 자바 소스 파일의 이름과 동일해야 한다.
public class csetest {
	// main 함수는 정적함수로 선언되어야 하고 String 타입 배열을 인자로 갖는다.
	public static void main(String[] args) {
		CSE cse = new CSE();

		// 인스턴스 최초 생성 시 title 변수에 할당된 문자열이 없으므로 할당해준다.
		cse.setTitle("이것은 CSE 클래스의 테스트입니다.");
		
		System.out.println(cse.getTitle());
	}
}