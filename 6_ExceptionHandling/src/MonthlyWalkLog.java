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
 * @author 김상진  
 * @file MonthlyWalkLog
 * 월별 걸음 거리 기록
 */
public class MonthlyWalkLog {
	private double[] dailyDistance = null;
	public final int year;
	public final int month;
	private LocalDate logDate;
	public MonthlyWalkLog() {
		logDate =  LocalDate.now();
		this.year = logDate.getYear();
		this.month = logDate.getMonthValue();
		dailyDistance = new double[logDate.lengthOfMonth()];
	}
	public MonthlyWalkLog(int year, int month) {
		LocalDate today = LocalDate.now();
		this.year = (year>=2000)? year: today.getYear();
		this.month = (month>=1&&month<=12)? month: today.getMonthValue();
		logDate = LocalDate.of(year, month, 1);
		dailyDistance = new double[logDate.lengthOfMonth()];
	} 
	public void recordDistance(int day, double distance) {
		dailyDistance[day-1] = distance;
	}
	public double getDistance(int day) {
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