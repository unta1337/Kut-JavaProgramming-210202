// 기관명: 한국기술교육대학교
// 학년도: 2021 학년도
// 교과목: 자바프로그래밍
// 주차: 6 주차
// 과제명: 예외 처리
// 저자: 2020136018 김성녕

public class MonthlyWalkLogException extends Exception {
	MonthlyWalkLogException(String message) {
		super(message);
	}
}

class NotTodayException extends MonthlyWalkLogException {
	NotTodayException(int day, int days) {
		super(String.format("유효하지 않은 날짜 | 예상: 1-%d 사이의 값 | 실제: %d", days, day));
	}
}

class MoonWalkException extends MonthlyWalkLogException {
	MoonWalkException(double distance) {
		super(String.format("유효하지 않은 거리 | 예상: 양수 | 실제: %f", distance));
	}
}