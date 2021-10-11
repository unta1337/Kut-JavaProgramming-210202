// 기관명: 한국기술교육대학교
// 학년도: 2021 학년도
// 교과목: 자바프로그래밍
// 주차: 6 주차
// 과제명: 예외 처리
// 저자: 2020136018 김성녕

import java.time.LocalDate;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 김상진, 김성녕
 * @file MonthlyWalkLog
 * 월별 걸음 거리 기록
 */
public class MonthlyWalkLog {
	private double[] dailyDistance = null;
	private final double maxDistance = 228.93;
	public final int year;
	public final int month;
	public final int days;
	private LocalDate logDate;
	public MonthlyWalkLog() {
		logDate =  LocalDate.now();
		this.year = logDate.getYear();
		this.month = logDate.getMonthValue();
		this.days = logDate.lengthOfMonth();
		dailyDistance = new double[days];
	}
	public MonthlyWalkLog(int year, int month) throws MonthlyWalkLogException {
		if (year <= 0)
			throw new BeforeChristianException(year);
		if (!(1 <= month && month <= 12))
			throw new UndecemberException(month);

		if (year >= 3000)
			throw new FuturamaException();

		// 예외 처리에 사용된 변수이므로 필요하지 않음.
		//LocalDate today = LocalDate.now();

		logDate = LocalDate.of(year, month, 1);

		// 도입부에서 예외 처리를 시행하였으므로 삼항 연산자가 필요하지 않음.
		this.year = year;
		this.month = month;

		this.days = logDate.lengthOfMonth();
		dailyDistance = new double[days];
	} 
	public void recordDistance(int day, double distance) throws MonthlyWalkLogException {
		if (!(1 <= day && day <= days))
			throw new NotTodayException(day, days);
		if (distance < 0)
			throw new MoonWalkException(distance);

		if (distance > maxDistance)
			throw new SuperManException(maxDistance, distance);

		dailyDistance[day-1] = distance;
	}
	public double getDistance(int day) throws MonthlyWalkLogException {
		if (!(1 <= day && day <= days))
			throw new NotTodayException(day, days);

		return dailyDistance[day-1];
	}
	public void print() {
		String[] weekdays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		System.out.printf("%d년 %d월%n", year, month);
		for(var weekday: weekdays)
			System.out.printf("%10s ", weekday);
		System.out.println();
		int w = logDate.getDayOfWeek().ordinal();
		System.out.print(" ".repeat((w+1)*11));
		int day=0;
		while(day<logDate.lengthOfMonth()) {
			System.out.printf("%10.2f ", dailyDistance[day]);
			++day;
			w = (w+1)%7;
			if(w==6) System.out.println();
		}
		
	}
}