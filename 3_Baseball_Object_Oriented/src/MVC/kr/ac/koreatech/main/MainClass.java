// 기관명: 한국기술교육대학교
// 학년도: 2021 학년도
// 교과목: 자바프로그래밍
// 주차: 3 주차
// 과제명: 객체지향 패턴으로 숫자 야구 게임 작성하기
// 저자: 2020136018 김성녕

package mvc.kr.ac.koreatech.main;

// 숫자 야구 게임을 하나의 라이브러리처럼 불러올 수 있도록 함.
import mvc.kr.ac.koreatech.baseball.Game;

public class MainClass {
	public static void main(String[] args) {
		Game.play();
	}
}
