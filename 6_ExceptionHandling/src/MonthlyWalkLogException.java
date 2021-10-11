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

class SuperManException extends MonthlyWalkLogException {
	SuperManException(double max, double distance) {
		super(String.format("당신은 슈퍼맨입니까? 사람은 하루에 %fkm 이상 걸을 수 없습니다. 그런데 당신은 %fkm를 걸으셨으니, 사실은 초인일지도요...", max, distance));
		// ref: https://www.guinnessworldrecords.com/world-records/64741-farthest-distance-walking-in-24-hours-male
	}
}

class FuturamaException extends MonthlyWalkLogException {
	FuturamaException() {
		super("미래에서 오신 분이군요! 2038년 문제는 해결되었나요?");
		// ref: https://namu.wiki/w/2038%EB%85%84%20%EB%AC%B8%EC%A0%9C
	}
}