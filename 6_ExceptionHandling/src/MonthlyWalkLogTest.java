// 기관명: 한국기술교육대학교
// 학년도: 2021 학년도
// 교과목: 자바프로그래밍
// 주차: 6 주차
// 과제명: 예외 처리
// 저자: 2020136018 김성녕

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 김상진  
 * @file MonthlyWalkLog
 * 월별 걸음 거리 기록 테스트 프로그램
 */
public class MonthlyWalkLogTest {

	public static void main(String[] args) {
		MonthlyWalkLog log = new MonthlyWalkLog();
		log.recordDistance(3, 5.5);
		log.print();

	}

}
