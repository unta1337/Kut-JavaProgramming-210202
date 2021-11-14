/**
 * 한국기술교육대학교 컴퓨터공학부
 * 2021년도 1학기 학기 프로젝트: 포켓몬팡
 * @author 김상진 
 * 그리드 위치를 유지하는 클래스
 */

// 2020136018 김성녕

public record Location(int r, int c){
	public static boolean valid(int r, int c){
		return (r>=0&&r<PangUtility.GRIDSIZE && 
				c>=0&&c<PangUtility.GRIDSIZE);
	}
}

